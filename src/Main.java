/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File: The main method that starts the application. Loads the table with all the pokemon listed.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("Views/SearchTableView.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add("Views/style.css");
         primaryStage.setScene(scene);
         primaryStage.setTitle("Pokédex");
         primaryStage.getIcons().add(new Image("Views/Icon.png"));
         primaryStage.show();
    }
}

