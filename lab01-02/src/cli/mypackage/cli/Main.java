package mypackage.cli;

import java.util.logging.*;
import random.*;
import java.util.*;
import datapackage.Person;
import mymathpackage.MyMath;
import java.net.http.*;
import java.io.*;
import java.net.*;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        // logger.log(Level.INFO, MyRandom.getInstance().getRandomWord("Hello", "World")); 

        // List<Person> list = MyRandom.getInstance().getRandomListOfPeopleWithNames("Jack", "Tina", "Paul", "John");
        // list.forEach(System.out::println);

        // System.out.println(MyMath.abs(-7));

        fetch();
    }


    public static void fetch() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://swapi.dev/api/people/"))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}