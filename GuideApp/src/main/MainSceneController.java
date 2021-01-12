package main;

import java.net.URL;
import java.util.ResourceBundle;

import guid.GuidSceneController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Line line_3;

    @FXML
    private Line line_4;

    @FXML
    private Line line_6;

    @FXML
    private Line line_7;

    @FXML
    private Line line_2;

    @FXML
    private Line line_5;

    @FXML
    private Line line_1;

    @FXML
    void guidMode(MouseEvent event) throws Exception {
        guid.GuidSceneMain guidScene = new guid.GuidSceneMain();
        guidScene.showWindow();
        Stage stage = (Stage) line_1.getScene().getWindow();
        stage.close();
    }

    @FXML
    void travelMode(MouseEvent event) throws Exception {
        travel.TravelSceneMain travelScene = new travel.TravelSceneMain();
        travelScene.showWindow();
        Stage stage = (Stage) line_1.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert line_3 != null : "fx:id=\"line_3\" was not injected: check your FXML file 'main.fxml'.";
        assert line_4 != null : "fx:id=\"line_4\" was not injected: check your FXML file 'main.fxml'.";
        assert line_6 != null : "fx:id=\"line_6\" was not injected: check your FXML file 'main.fxml'.";
        assert line_7 != null : "fx:id=\"line_7\" was not injected: check your FXML file 'main.fxml'.";
        assert line_2 != null : "fx:id=\"line_2\" was not injected: check your FXML file 'main.fxml'.";
        assert line_5 != null : "fx:id=\"line_5\" was not injected: check your FXML file 'main.fxml'.";
        assert line_1 != null : "fx:id=\"line_1\" was not injected: check your FXML file 'main.fxml'.";

    }
}
