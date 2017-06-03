package pl.sahee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.Random;

public class Controller {

    @FXML
    Button runningButton;

    @FXML
    private void initialize() {

        runningButton.setOnMouseEntered(event -> changePosOfButton());
        runningButton.setOnMouseClicked(event -> changePosOfButton());
    }

    private void changePosOfButton() {
        Random r = new Random();
        runningButton.setTranslateX(r.nextInt(500));
        runningButton.setTranslateY(r.nextInt(350));
        runningButton.setRotate(r.nextInt(300));
    }
}
