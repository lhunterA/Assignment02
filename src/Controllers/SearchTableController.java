package Controllers;

import Models.Pokemon;

import Utilities.JsonFileUtil;
import Utilities.PokeApiUtil;
import Utilities.SceneChange;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchTableController implements Initializable {

    @FXML
    private ListView<Pokemon> resultListView;

    @FXML
    private Label rowsReturnedLabel;

    @FXML
    private ImageView imageView;

    private Pokemon response;

    private Pokemon pokemonToPass;
    String str;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 30; i++) {
            PokeApiUtil.getPokemonOnLoad(i);
            File jsonFile = new File("src/pokedex.json");
            response = JsonFileUtil.getPokemonInfoFromJson(jsonFile);
            resultListView.getItems().addAll(response); //return an array of pokemon - Auto calls toString
        }

        rowsReturnedLabel.setText("Number Showing: " + resultListView.getItems().size());

        resultListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, pokemonSelected) -> {
                    imageView.setImage(new Image(pokemonSelected.getSprites().getFront_default())); //add the sprite variable to the image view
                });
            }
    @FXML
    private void viewPokemonDetails(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new Object(){}.getClass().getResource("../Views/PokemonDetailsView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            PokemonDetailsController controller = loader.getController();
            controller.setPokemon(resultListView.getSelectionModel().getSelectedItem());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Pokedex");

            stage.show();
        }
}