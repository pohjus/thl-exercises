package mypackage;

import java.util.logging.*;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        logger.log(Level.INFO, "Hello World!"); 
    }
}