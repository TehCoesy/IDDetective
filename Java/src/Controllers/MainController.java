package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    Button cropButton;
    @FXML
    Button fieldsButton;

    public void init() {
        initButtons();
    }

    private void initButtons() {
        cropButton.setOnAction(e -> {
            CropVisualizerController window = new CropVisualizerController();
        });

        fieldsButton.setOnAction(e -> {
            FieldVisualizerController window = new FieldVisualizerController();
        });
    }
}
