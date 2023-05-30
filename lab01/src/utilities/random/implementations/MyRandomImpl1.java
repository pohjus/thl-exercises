
package implementations;
 
import java.util.Random;
import random.*;

public class MyRandomImpl1 implements MyRandom {
      public String getRandomWord(String... args) {
            return args[new Random().nextInt(args.length)];
      }
}