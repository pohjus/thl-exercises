
package implementations;
 
import java.util.Random;
import random.*;
import java.util.logging.*;

public class MyRandomImpl1 implements MyRandom {
      private final Logger logger = Logger.getLogger(MyRandomImpl1.class.getName());

      public String getRandomWord(String... args) {
            logger.log(Level.INFO, "MyRandomImpl1 called, using Math.random()"); 

            return args[new Random().nextInt(args.length)];
      }
}