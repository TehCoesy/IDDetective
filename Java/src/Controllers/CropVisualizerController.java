package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CropVisualizerController {
    Stage m_stage = new Stage();

    public CropVisualizerController() {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CropVisualizer.fxml"));
            root = loader.load();
        } catch (Exception e) {
            System.out.println("CropVisualizerController: Failed to load FXML.");
            e.printStackTrace();
            return;
        }

        Scene m_scene = new Scene(root);
        m_stage.setScene(m_scene);
        m_stage.initModality(Modality.APPLICATION_MODAL);
        m_stage.setTitle("Crop Visualizer");
        m_stage.setResizable(false);
        m_stage.show();
    }
}
