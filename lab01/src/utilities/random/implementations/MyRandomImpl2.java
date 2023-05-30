
package implementations;
 
import random.*;

public class MyRandomImpl2 implements MyRandom {
      public String getRandomWord(String... args) {
            return args[(int) (Math.random() * args.length)];
      }
}