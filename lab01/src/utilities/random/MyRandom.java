
package random;
 
import java.util.Random;

public class MyRandom {
      public static String getRandomWord(String... args) {
            return args[new Random().nextInt(args.length)];
      }
}