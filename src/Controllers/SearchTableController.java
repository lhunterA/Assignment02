package Controllers;

import Models.ApiResponse;

import Utilities.JsonFileUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    @FXML
    public void searchButton()
    {
        String searchText = searchTextField.getText();
       // JsonFileUtil;

        //read the json file and create an api model
        File jsonFile = new File("src/pokedex.json");
        response = JsonFileUtil.getPokemonInfoFromJson(jsonFile);

    }
}
