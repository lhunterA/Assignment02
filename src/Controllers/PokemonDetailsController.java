package Controllers;


import Models.Pokemon;
import Utilities.SceneChange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PokemonDetailsController implements Initializable {

    @FXML private Label nameLabel;

    @FXML private Label numLabel;

    @FXML private ImageView spriteImageView;

    private Pokemon pokemon;


    public void setPokemon(Pokemon pokemon)
    {
        this.pokemon = pokemon;
        nameLabel.setText(pokemon.getName());
        numLabel.setText(pokemon.getPokedexNum());
        spriteImageView.setImage(new Image(pokemon.getSprites().getFront_default()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        SceneChange.changeScene(event, "../Views/searchTableView.fxml", "Pokedex");
    }
}
