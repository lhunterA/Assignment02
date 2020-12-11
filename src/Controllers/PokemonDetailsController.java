/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File: Contains the logic and sets the pokemon selected and formats the labels to the selected pokemon properties.
 */

package Controllers;

import Models.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PokemonDetailsController implements Initializable {

    @FXML private Label nameLabel;
    @FXML private Label numLabel;
    @FXML private ImageView spriteImageView;
    @FXML private Label pokemonHeightLabel;
    @FXML private Label pokemonWeightLabel;
    @FXML private Label baseExperienceLabel;
    private Pokemon pokemon;

    /**
     * Setting the pokemon selected from the SearchTableController and assigning the values to the labels
     * @param pokemon
     */
    public void setPokemon(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        nameLabel.setText(pokemon.getName());
        numLabel.setText(String.valueOf(pokemon.getPokedexNum()));
        spriteImageView.setImage(new Image(pokemon.getSprites().getFront_default()));
        pokemonHeightLabel.setText(pokemon.getHeight() + "cm");
        pokemonWeightLabel.setText(pokemon.getWeight() + "kg");
        baseExperienceLabel.setText(String.valueOf(pokemon.getBaseExperience()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    /**
     * Original Code from Jaret Wright - COMP 1011- Class - Week 06.
     * Change the scene back to the main view with all the pokemon to learn about.
     *
     * Will be called when the button on this view is clicked.
     * @param event
     * @throws IOException
     */
    @FXML
    public void goBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource("../Views/SearchTableView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pokédex");
        stage.show();
    }
}
