package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.File;

public class CropVisualizerController {
    Stage m_stage = new Stage();

    //Components
    private Button b_previous;
    private Button b_next;
    private ImageView img_input;
    private ImageView img_output;

    //Parameters
    private File dir_input, dir_output;
    private Image[] imgs_input, imgs_output;
    private int index = 0, size = 1;

    //IO
    JSONObject jsonReader = new JSONObject();


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

        b_previous = (Button) m_scene.lookup("#b_previous");
        b_next = (Button) m_scene.lookup("#b_next");
        img_input = (ImageView) m_scene.lookup("#img_input");
        img_output = (ImageView) m_scene.lookup("#img_output");

        setControls();
    }

    //Controls
    private void setControls() {
        b_previous.setOnAction(e -> {
            if (index > 0) {
                index--;
            }
            loadImage();
        });
        b_next.setOnAction(e -> {
            if (index < size) {
                index++;
            }
            loadImage();
        });
    }


    //Image processing
    private void loadImage() {
        img_input.setImage(imgs_input[index]);
        img_output.setImage(imgs_output[index]);
    }
}
