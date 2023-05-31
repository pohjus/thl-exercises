
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

public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GUI App");
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink"};
        
        Button button = new Button();
        final StackPane layout = new StackPane(button);
        
        button.setText("Click Me!");
        //button.setOnAction((e) -> layout.setStyle("-fx-background-color: " + MyRandom.getInstance().getRandomWord(colors)));

        button.setOnAction(this::fetchAsync);    

        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();
    }


    public void fetchAsync(ActionEvent event) {
         try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://swapi.dev/api/people/"))
                    .build();

            var promise = client.sendAsync(request,
                    HttpResponse.BodyHandlers.ofString());


            logger.log(Level.INFO, "Async test: Start"); 
            promise.thenAccept(response -> {
                System.out.println(response.statusCode());        
                System.out.println(response.body());
            });
            logger.log(Level.INFO, "Async test: End"); 
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}