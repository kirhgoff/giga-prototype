import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openspaces.core.GigaSpace;

import java.util.function.Function;

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

interface MessageFactory {
  Object create(int index);
  String getTestName();
}

public class Feeder {
  private static Log logger = LogFactory.getLog(Feeder.class);

  private GigaSpace gigaSpace;

  public Feeder(GigaSpace gigaSpace) {
    this.gigaSpace = gigaSpace;
  }

  public TestResult runTest (Class factoryClass, int count) throws Exception {
    //Generate objects
    MessageFactory factory = (MessageFactory) factoryClass.newInstance();
    Object[] messages = generateObjects(count, factory);

    //Run simple test
    long startTime = System.currentTimeMillis();
    feed (messages);
    long timeRunningMillis = System.currentTimeMillis() - startTime;

    //Calculate stats
    double average = ((double)timeRunningMillis)/count;
    double throughputSec = count*1000/timeRunningMillis;

    return new TestResult(factory.getTestName (), count, average, throughputSec);
  }

  private Object[] generateObjects(int count, MessageFactory factory) {
    Object [] messages = new Object [count];
    for(int i=0; i < count; i ++){
      messages[i] = factory.create(i);
    }
    return messages;
  }

  public void feed (Object [] messages) throws Exception {
    int count = messages.length;
    for(int i=0; i < count; i ++){
      gigaSpace.write (messages[i]);
    }
  }

}