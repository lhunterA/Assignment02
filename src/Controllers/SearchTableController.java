package Controllers;

import Models.ApiResponse;

import Utilities.JsonFileUtil;
import Utilities.PokeApiUtil;
import Utilities.SceneChange;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchTableController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<ApiResponse> resultListView;

    @FXML
    private Label rowsReturnedLabel;

    private ApiResponse response;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    //when button pushed will take the text, send to api and get our list
    @FXML
    public void searchButton()
    {
        String searchText = searchTextField.getText();

        //call the api and save search to the json file.
        PokeApiUtil.getPokemonFromSearchBar(searchText);

        //read the json file and create an api model
        File jsonFile = new File("src/pokedex.json");

        response = JsonFileUtil.getPokemonInfoFromJson(jsonFile);

        //Display for the application - Clears and adds to list view
        resultListView.getItems().clear();//clear the list of previous searches.
        resultListView.getItems().addAll(response); //return an array of movie objects - Auto calls toString
        rowsReturnedLabel.setText("Number Showing: " + resultListView.getItems().size());
    }
}
