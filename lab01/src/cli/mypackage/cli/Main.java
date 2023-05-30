package mypackage.cli;

import java.util.logging.*;
import random.*;
import java.util.*;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        logger.log(Level.INFO, getRandom().getRandomWord("Hello", "World")); 
    }

    public static MyRandom getRandom() {
        logger.log(Level.INFO, "MyRandomImpl1 called, using new Random()"); 

        ServiceLoader<MyRandom> services = ServiceLoader.load(MyRandom.class);
        return services.findFirst().get();
    }
}