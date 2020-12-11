/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File: Initializes the JSON and API utilities from the Utilities folder. Calls the API by the pokedex number
 * at the start of intialize() and displays it to the listview. Can learn more about the pokemon by clicking on its image
 */

package Controllers;

import Models.Pokemon;

import Utilities.JsonFileUtil;
import Utilities.PokeApiUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchTableController implements Initializable
{
    @FXML private ListView<Pokemon> resultListView;
    @FXML private Label rowsReturnedLabel;
    @FXML private ImageView imageView;
    private Pokemon pokemon;
    @FXML private Label learnMoreLabel;
    @FXML private StackPane imgStackPane;

    /**
     * The method initialize() sets the learnMoreLabel, imgStackPane, and imageView visibility as false.
     *
     * A for loop is used to call the API get method as it can take in a number so using the pokedex numbers (each pokemon
     * is assigned a unique number 'id') to grab the information. Where it will then write the informatio to the pokedex.json
     * file. Grab the wanted information and pass it to the pokemon model, and add it to the listview.
     *
     * Updates the output label to know how many pokemon were retreived.
     *
     *  This Listener original code is from Jaret Wright - COMP 1011- Class - Week 11.
     * Add a listener to the listview so that when a pokemon is clicked by the mouse the image from the API is outputted
     * to the ImageView, and the learnMoreLabel, imgStackPane, and imageView visibility is than set to true.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        learnMoreLabel.setVisible(false);
        imageView.setVisible(false);
        imgStackPane.setVisible(false);

        for (int i = 1; i <= 60; i++) //for each pokemon (150). Could output 809.
        {
            PokeApiUtil.getPokemonOnLoad(i);
            File jsonFile = new File("src/pokedex.json");
            pokemon = JsonFileUtil.getPokemonInfoFromJson(jsonFile);
            resultListView.getItems().addAll(pokemon);
        }

        rowsReturnedLabel.setText("Number Showing: " + resultListView.getItems().size());

        resultListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, pokemonSelected) -> {
                    imageView.setImage(new Image(pokemonSelected.getSprites().getFront_default()));
                    learnMoreLabel.setVisible(true);
                    imageView.setVisible(true);
                    imgStackPane.setVisible(true);
                });
    }

    /**
     * Original Code from Jaret Wright - COMP 1011- Class - Week 06.
     * When the user has a mouse click event on the image of the pokemon the scene will change to the details page.
     *
     * Code 94 and 95 were taken from:
     * Jaret Wright youtube video Passing information between Scenes with Javafx
     * https://www.youtube.com/watch?v=Wc1a2KshJ4w&feature=youtu.be&ab_channel=JaretWright
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void viewPokemonDetails(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource("../Views/PokemonDetailsView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        PokemonDetailsController controller = loader.getController();
        controller.setPokemon(resultListView.getSelectionModel().getSelectedItem());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pokédex");
        stage.show();
    }
}