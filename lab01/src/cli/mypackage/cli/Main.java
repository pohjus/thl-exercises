package mypackage.cli;

import java.util.logging.*;
import random.*;
import java.util.*;
import datapackage.Person;
import mymathpackage.MyMath;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        logger.log(Level.INFO, MyRandom.getInstance().getRandomWord("Hello", "World")); 

        List<Person> list = MyRandom.getInstance().getRandomListOfPeopleWithNames("Jack", "Tina", "Paul", "John");
        list.forEach(System.out::println);

        System.out.println(MyMath.abs(-7));
    }
}