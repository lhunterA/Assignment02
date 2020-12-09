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
         Parent root = FXMLLoader.load(getClass().getResource("Views/searchTableView.fxml"));
         Scene scene = new Scene(root);
         //scene.getStylesheets().add("Utilities/styleSheet.css");
         primaryStage.setScene(scene);
         primaryStage.setTitle("Pokédex");
         primaryStage.getIcons().add(new Image("Views/Icon.png"));
         primaryStage.show();
    }
}

