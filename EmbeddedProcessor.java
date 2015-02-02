import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;
import org.openspaces.admin.gsm.GridServiceManager;
import org.openspaces.admin.pu.ProcessingUnit;
import org.openspaces.admin.space.Space;
import org.openspaces.admin.space.SpaceDeployment;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.CannotFindSpaceException;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.core.space.cache.LocalCacheSpaceConfigurer;

import org.springframework.transaction.TransactionStatus;
import org.openspaces.events.notify.SimpleNotifyEventListenerContainer;
import org.openspaces.events.notify.SimpleNotifyContainerConfigurer;
import org.openspaces.events.SpaceDataEventListener;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 

import com.j_spaces.core.IJSpace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmbeddedProcessor {
  public static final String SPACE_NAME = "space";
  private static Log logger = LogFactory.getLog(EmbeddedProcessor.class);

  public static void main (String [] args) throws Exception {
    logger.info("Looking for space or creating one");
    GigaSpace gigaSpace = null;
    UrlSpaceConfigurer configurer = new UrlSpaceConfigurer("jini:/*/*/" + SPACE_NAME);
    try {
    	IJSpace ijSpace = configurer.space();
      gigaSpace = new GigaSpaceConfigurer(ijSpace).gigaSpace();
    }
    catch (CannotFindSpaceException cfse) {
      logger.info ("Creating admin");
      Admin admin = new AdminFactory().createAdmin();
      logger.info ("Creating GSM");
      GridServiceManager esm = admin.getGridServiceManagers().waitForAtLeastOne();

      logger.info ("Creating PU");
      ProcessingUnit processingUnit = esm.deploy(new SpaceDeployment(SPACE_NAME).partitioned(1, 1));

      logger.info("Waiting for space");
      Space space = processingUnit.waitForSpace();
      space.waitFor(2);
      gigaSpace = space.getGigaSpace();

      logger.info("Closing admin");
      admin.close();
   }

    logger.info("Starting write loop");
    Class [] tests = new Class [] {
//        Tests.SmallMessageSimpleIndicesTest.class,
        Tests.SmallMessageCompexKeyTest.class,
//        Tests.SmallMessageCompoundIndexTest.class,
        Tests.SmallMessageCompexKeyCompoundIndexTest.class
    };

    List<TestResult> results = new LinkedList<>();

    Feeder feeder = new Feeder (gigaSpace);
    for (Class testClass : tests) {
      for (int i = 0; i < 10; i++) {
        TestResult result = feeder.runTest(testClass, 10000);
        System.out.println(result);
        results.add(result);
      }
    }

    //results.stream().forEach(System.out::println);
  }
}

// logger.info("Space found, starting listener");
// SimpleNotifyEventListenerContainer eventListener = new SimpleNotifyContainerConfigurer(gigaSpace)
//   .eventListenerAnnotation(new Object() {
//    	@SpaceDataEvent
//     public void eventHappened(Message data) {
//     	logger.info("Got notification " + data);
//     }
//   })
//   .notifyContainer();

// eventListener.start();

