import com.j_spaces.core.IJSpace;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 

import java.math.BigDecimal;
import java.util.Random;

public class Feeder {
  private static Log logger = LogFactory.getLog(Feeder.class);

  private static final String CHARS = "qwertyuiop[]asdfghjkl;'zxcvbnm,.1234567890-=";
  private static final double RANGE_MAX = Double.MAX_VALUE;
  private static final double RANGE_MIN = Double.MIN_VALUE;

  private GigaSpace gigaSpace;

  public Feeder(GigaSpace gigaSpace) {
       this.gigaSpace = gigaSpace;
  }

  public void feed (int count) throws Exception {
    SmallMessage [] SmallMessages = prepareSmallMessages(count);
    long startTime = System.currentTimeMillis();
    for(int i=0; i < count; i ++){
      gigaSpace.write (SmallMessages[i]);
    }
    long timeRunningMillis = System.currentTimeMillis() - startTime; 
    double average = ((double)timeRunningMillis)/count;
    double throuputSec = count*1000/timeRunningMillis;

    System.out.println("Average time per object: " + average + " ms, throughput: " + throuputSec + " objects per sec");
  }

  public SmallMessage [] prepareSmallMessages (int count) {
    Random random = new Random();          
    SmallMessage [] SmallMessages = new SmallMessage [count];    
    for(int i=0; i < count; i ++){
      SmallMessages[i] = new SmallMessage (i, generateString(random, CHARS, 20), generarateBigDecimal(random));
    }
    return SmallMessages;    
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