import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.Random;

public class Tests {

  private static final String CHARS = "qwertyuiop[]asdfghjkl;'zxcvbnm,.1234567890-=";
  private static final double RANGE_MAX = Double.MAX_VALUE;
  private static final double RANGE_MIN = Double.MIN_VALUE;
  private static Random random = new Random();

  public static class SmallMessageSimpleIndicesTest implements MessageFactory {
    public Object create(int index) {return new SmallMessageSimpleIndices(index,generateString(
        random, CHARS, 20),generarateBigDecimal(random));}
    public String getTestName() {return "SmallMessageSimpleIndices";}
  }

  public static class SmallMessageCompexKeyTest implements MessageFactory {
    public Object create(int index) {return new SmallMessageCompexKey(index,generateString(random, CHARS, 20),generarateBigDecimal(random));}
    public String getTestName() {return "SmallMessageCompexKey";}
  }

  public static class SmallMessageCompoundIndexTest implements MessageFactory {
    public Object create(int index) {return new SmallMessageCompoundIndex(
        index,
        generateString(random, CHARS, 20),
        generateString(random, CHARS, 100),
        generarateBigDecimal(random)
    );}
    public String getTestName() {return "SmallMessageCompoundIndex";}
  }

  public static class SmallMessageCompexKeyCompoundIndexTest implements MessageFactory {
    public Object create(int index) {return new SmallMessageComplexKeyCompoundIndex(
        index,
        generateString(random, CHARS, 20),
        generateString(random, CHARS, 100),
        generarateBigDecimal(random)
    );}
    public String getTestName() {return "SmallMessageComplexKeyCompoundIndex";}
  }

  //-------------------------- Utility methods ----------------------------------
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
