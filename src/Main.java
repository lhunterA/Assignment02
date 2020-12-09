import Models.APIResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;

public class Main extends Application {

    public static void main(String[] args) {
        //launch(args);

        try(
                FileReader fileReader = new FileReader("src/pokedex.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )

        {
            Gson gson = new Gson();
            APIResponse apiResponse = gson.fromJson(jsonReader, APIResponse.class);
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
/*        Parent root = FXMLLoader.load(getClass().getResource("FXML"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();*/

    }
}

// https://pokeapi.co/api/v2/pokemon/{id or name}/