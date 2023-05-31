
package mypackage.gui;
 
import random.MyRandom;
 
import javafx.application.*;
import javafx.event.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;
import java.util.logging.*;

import java.net.http.*;
import java.io.*;
import java.net.*;
import com.fasterxml.jackson.databind.*;
import datapackage.*;
import com.fasterxml.jackson.core.*;

import javafx.collections.*;


public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // public static void main(String[] args) {
    //     launch(args);
    // }
 
    // @Override
    // public void start(Stage primaryStage) {
    //     primaryStage.setTitle("GUI App");
    //     String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink"};
        
    //     Button button = new Button();
    //     final StackPane layout = new StackPane(button);
        
    //     button.setText("Click Me!");
    //     //button.setOnAction((e) -> layout.setStyle("-fx-background-color: " + MyRandom.getInstance().getRandomWord(colors)));

    //     button.setOnAction(this::fetchAsync);    

    //     primaryStage.setScene(new Scene(layout, 300, 250));
    //     primaryStage.show();
    // }


    private ObservableList<String> names;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        names = FXCollections.observableArrayList();
        listView = new ListView<String>();
        listView.setItems(names);
        primaryStage.setTitle("Star Wars API");
        primaryStage.setScene(new Scene(listView, 300, 250));
        primaryStage.show();
        fetchAsync();
    }


    public void fetchAsync() {
         try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://swapi.dev/api/people/"))
                    .build();

            var promise = client.sendAsync(request,
                    HttpResponse.BodyHandlers.ofString());


            promise.thenAccept(r -> parse(r.body()));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void parse(String result) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            People p = objectMapper.readValue(result, People.class);
            
            System.out.println(p.results);

            p.results.stream()
                .sorted(Comparator.comparingDouble(Person::getBmi))
                .map(Person::toString)
                .forEach(person -> listView.getItems().add(person));

            System.out.println("b");

        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}