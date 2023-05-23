package mypackage.cli;

import java.util.logging.*;
import random.*;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        logger.log(Level.INFO, MyRandom.getRandomWord("Hello", "World")); 
    }
}