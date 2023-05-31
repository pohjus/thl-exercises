
package implementations;
 
import random.*;

import java.util.logging.*;

public class MyRandomImpl2 implements MyRandom {

      private final Logger logger = Logger.getLogger(MyRandomImpl2.class.getName());

      public String getRandomWord(String... args) {
            logger.log(Level.INFO, "MyRandomImpl2 called, using Math.random()"); 
            return args[(int) (Math.random() * args.length)];
      }
}