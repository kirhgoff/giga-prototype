import com.j_spaces.core.IJSpace;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.cluster.ClusterInfo;
import org.openspaces.core.space.UrlSpaceConfigurer;

import java.math.BigDecimal;
import java.util.Random;

public class EmbeddedProcessor {

  private static Log logger = LogFactory.getLog(EmbeddedProcessor.class);
  public static final int ITERATIONS = 10;
  public static final int BATCH_SIZE = 2000;
  public static final Class[] TEST_CASES = new Class[]{
      Tests.SmallMessageTest.class,
      Tests.BigMessageTest.class
  };

  public static void main (String [] args) throws Exception {

    ClusterInfo clusterInfo = new ClusterInfo(null, 1, null, 1, null);
    IJSpace space = new UrlSpaceConfigurer("/./eifSpace").clusterInfo(clusterInfo).space();
    GigaSpace gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();

    logger.info("Starting write loop");

    Feeder feeder = new Feeder (gigaSpace);
    for (Class testClass : TEST_CASES) {
      for (int i = 0; i < ITERATIONS; i++) {
        System.out.println(feeder.runTest(testClass, BATCH_SIZE));
        feeder.reset();
      }
    }

    System.exit(0);
  }

}

// --------------------------- Test result --------------------------
class TestResult {

  private String testName;
  private int count;
  private double average;
  private double throughput;

  public TestResult (String testName, int count, double average, double throughput) {

    this.testName = testName;
    this.count = count;
    this.average = average;
    this.throughput = throughput;
  }

  public String toString () {
    return "Test[" + testName + "] count=" + count + ", avg=" + average + " ms, throughput=" + throughput + " obj per sec.";
  }
}

// --------------------------- Factory --------------------------

interface MessageFactory {
  Object create(int index);
  Object amend(Object object);
  String getTestName();
}

// --------------------------- Feeder --------------------------

class Feeder {
  private static Log logger = LogFactory.getLog(Feeder.class);
  private Object [] messages;
  private GigaSpace gigaSpace;

  public Feeder(GigaSpace gigaSpace) {
    this.gigaSpace = gigaSpace;
  }

  public TestResult runTest (Class factoryClass, int count) throws Exception {
    //Generate objects
    MessageFactory factory = (MessageFactory) factoryClass.newInstance();
    if (messages == null) {
      messages = generateObjects(count, factory);
    } else {
      amend (messages, factory);
    }

    //Run simple test
    long startTime = System.currentTimeMillis();
    feed (messages);
    long timeRunningMillis = System.currentTimeMillis() - startTime;

    //Calculate stats
    double average = ((double)timeRunningMillis)/count;
    double throughputSec = count*1000/timeRunningMillis;

    return new TestResult(factory.getTestName (), count, average, throughputSec);
  }

  private void amend(Object[] messages, MessageFactory factory) {
    for (Object message : messages) {
      factory.amend(message);
    }
  }

  private Object[] generateObjects(int count, MessageFactory factory) {
    Object [] messages = new Object [count];
    for(int i=0; i < messages.length; i ++){
      messages[i] = factory.create(i);
    }
    return messages;
  }

  public void feed (Object [] messages) throws Exception {
    for (Object message : messages) {
      gigaSpace.write(message);
    }
  }

  public void reset() {
    messages = null;
  }
}

//----------------------------- Tests -----------------------------

class Tests {

  private static final String CHARS = "qwertyuiop[]asdfghjkl;'zxcvbnm,.1234567890-=";
  private static final double RANGE_MAX = Double.MAX_VALUE;
  private static final double RANGE_MIN = Double.MIN_VALUE;
  private static Random random = new Random();

  public static class SmallMessageTest implements MessageFactory {
    public Object create(int index) {
      SmallMessage message =
          new SmallMessage(
              index,
              generateString(random, CHARS, 10),
              generarateBigDecimal(random)
          );
      amend (message);
      return message;
    }

    @Override
    public Object amend(Object object) {
      SmallMessage message = (SmallMessage) object;
      message.setInfo2(generateString(random, CHARS, 15));
      message.setPrice2(generarateBigDecimal(random));
      return message;
    }

    public String getTestName() {return "SmallMessageComplexKeyCompoundIndex";}
  }

  public static class BigMessageTest implements MessageFactory {
    public Object create(int index) {
      BigMessage message = new BigMessage(
        index,
        generateString(random, CHARS, 5),
        generateString(random, CHARS, 10),
        generateString(random, CHARS, 15),
        generarateBigDecimal(random),
        generarateBigDecimal(random)
      );
      amend(message);
      return message;
    }

    @Override
    public Object amend(Object object) {
      BigMessage message = (BigMessage) object;
      message.setInfo3(generateString(random, CHARS, 5));
      message.setInfo4(generateString(random, CHARS, 10));
      message.setInfo5(generateString(random, CHARS, 15));
      message.setInfo6(generateString(random, CHARS, 5));
      message.setInfo7(generateString(random, CHARS, 10));
      message.setInfo8(generateString(random, CHARS, 15));
      message.setInfo9(generateString(random, CHARS, 5));
      message.setInfo10(generateString(random, CHARS, 10));
      message.setInfo11(generateString(random, CHARS, 15));
      message.setInfo12(generateString(random, CHARS, 5));
      message.setInfo13(generateString(random, CHARS, 10));
      message.setInfo14(generateString(random, CHARS, 15));
      message.setInfo15(generateString(random, CHARS, 5));

      message.setPrice3(generarateBigDecimal(random));
      message.setPrice4(generarateBigDecimal(random));
      message.setPrice5(generarateBigDecimal(random));
      message.setPrice6(generarateBigDecimal(random));
      message.setPrice7(generarateBigDecimal(random));
      message.setPrice8(generarateBigDecimal(random));
      message.setPrice9(generarateBigDecimal(random));
      message.setPrice10(generarateBigDecimal(random));
      message.setPrice11(generarateBigDecimal(random));
      message.setPrice12(generarateBigDecimal(random));
      message.setPrice13(generarateBigDecimal(random));
      message.setPrice14(generarateBigDecimal(random));
      message.setPrice15(generarateBigDecimal(random));
      message.setPrice16(generarateBigDecimal(random));
      message.setPrice17(generarateBigDecimal(random));
      message.setPrice18(generarateBigDecimal(random));
      message.setPrice19(generarateBigDecimal(random));
      message.setPrice20(generarateBigDecimal(random));
      message.setPrice21(generarateBigDecimal(random));
      message.setPrice22(generarateBigDecimal(random));
      message.setPrice23(generarateBigDecimal(random));
      return message;
    }

    public String getTestName() {return "BigMessage";}
  }

  public static String generateString(Random random, String characters, int length) {
    char[] text = new char[length];
    for (int i = 0; i < length; i++) {
      text[i] = characters.charAt(random.nextInt(characters.length()));
    }
    return new String(text);
  }

  public static BigDecimal generarateBigDecimal (Random random) {
    double randomValue = RANGE_MIN + (RANGE_MAX - RANGE_MIN) * random.nextDouble();
    return new BigDecimal (randomValue);
  }

}