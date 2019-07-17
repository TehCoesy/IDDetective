import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/MainMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        MainController mainController = loader.getController();

        stage.setTitle("Visualizer");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        mainController.init();
    }
}
