package Utilities;

import Controllers.PokemonDetailsController;
import Models.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *  * Lindsay Hunter
 *  * 200425671
 */

public class SceneChange {

    /**
     * Original Code from Jaret Wright - COMP 1011- Class - Week 06.
     * Will automate the process of changing the scenes on the stage of the Main Class
     *
     * This method will change to the view.fxml file provided
     * Method changeScene() which takes 2 arguments, the fxml file that wants to be view and the new title for the new scene.
     */
    public static void changeScene(ActionEvent event,String viewName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }




}