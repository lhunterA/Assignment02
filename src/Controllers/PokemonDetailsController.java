package Controllers;


import Models.Pokemon;
import Utilities.JsonFileUtil;
import Utilities.SceneChange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PokemonDetailsController implements Initializable {

    @FXML private Label nameLabel;
    private Pokemon pokemon;


    public void setPokemon(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        System.out.println(pokemon + "In the set pokemon method");
        nameLabel.setText(pokemon.getName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        SceneChange.changeScene(event, "../Views/searchTableView.fxml", "Pokedex");
    }
}
