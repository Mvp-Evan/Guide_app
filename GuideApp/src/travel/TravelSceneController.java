package travel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import main.Point;

public class TravelSceneController {

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
    private TextField position;

    @FXML
    private Label showText;

    // recode the way of points to a array
    public static int[][] pointWay = {
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 0}
    };

    // init the every line between points
    void drawLine(){
        line_1.setStrokeWidth(1);
        line_2.setStrokeWidth(1);
        line_3.setStrokeWidth(1);
        line_4.setStrokeWidth(1);
        line_5.setStrokeWidth(1);
        line_6.setStrokeWidth(1);
        line_7.setStrokeWidth(1);
    }

    // judge point which is input whether can make way to any others point
    boolean judgePosition(String position){
        switch (position) {
            case "中博湖":
            case "计算机学科楼":
                line_1.setStrokeWidth(0);
                line_5.setStrokeWidth(0);
                break;
            case "图书馆":
            case "鼎山":
                line_4.setStrokeWidth(0);
                line_5.setStrokeWidth(0);
                break;
            case "南区运动场":
                line_5.setStrokeWidth(0);
                line_7.setStrokeWidth(0);
                break;
            case "北区运动场":
                line_2.setStrokeWidth(0);
                line_5.setStrokeWidth(0);
                break;
            case "大学生活动中心":
                line_6.setStrokeWidth(0);
                line_5.setStrokeWidth(0);
                break;
        }

        return true;
    }

    int switchPointToNumber(String position){
        if(position.equals("中博湖")){
            return 1;
        }
        else if(position.equals("图书馆")){
            return 2;
        }
        else if(position.equals("鼎山")){
            return 3;
        }
        else if(position.equals("计算机学科楼")){
            return 4;
        }
        else if(position.equals("南区运动场")){
            return 5;
        }
        else if(position.equals("北区运动场")){
            return 6;
        }
        else if(position.equals("大学生活动中心")){
            return 7;
        }
        else {
            return 0;
        }
    }

    // judge point whether can get every way
    boolean judgeWay(String position){
        int point = switchPointToNumber(position) - 1;

        if(point == -1){
            return false;
        }
        else{
            int count = 0; // recode degree of node whether is odd
            int oddNod = 0; // recode the number of odd nod

            // search in every node
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if(pointWay[i][j] == 1){
                        count++;
                    }
                }
                if(count%2 != 0){  // judge odd
                    oddNod++;
                    count = 0;
                }
                else {
                    count = 0;
                }
            }

            // judge this point whether is odd node
            if(oddNod == 2){
                for (int i = 0; i < 7; i++) {
                    if(pointWay[point][i] == 1){
                        count++;
                    }
                }
                return count % 2 != 0;
            }
            else {
                return false;
            }
        }


    }

    @FXML
    void travelPoint(MouseEvent event) {
        showText.setText("");
        drawLine();

        // get the point name which user input
        String point = position.getText();

        //set a bool value to get this point whether can to any point
        boolean canDo = judgePosition(point);
        if(!canDo){
            showText.setText("不能遍历所有景点");
        }
    }

    @FXML
    void travelWay(MouseEvent event) {
        showText.setText("");
        drawLine();

        String point = position.getText();
        boolean canDo = judgeWay(point);

        if(!canDo){
            showText.setText("不能遍历全部路线");
        }
        else {
            showText.setText("可以遍历全部路线");
        }

    }

    @FXML
    void back(MouseEvent event) throws Exception {
        main.MainScene mainScene = new main.MainScene();
        mainScene.showWindow();
        Stage stage = (Stage) line_1.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert line_3 != null : "fx:id=\"line_3\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_4 != null : "fx:id=\"line_4\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_6 != null : "fx:id=\"line_6\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_7 != null : "fx:id=\"line_7\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_2 != null : "fx:id=\"line_2\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_5 != null : "fx:id=\"line_5\" was not injected: check your FXML file 'Travel.fxml'.";
        assert line_1 != null : "fx:id=\"line_1\" was not injected: check your FXML file 'Travel.fxml'.";
        assert position != null : "fx:id=\"position\" was not injected: check your FXML file 'Travel.fxml'.";
        assert showText != null : "fx:id=\"showText\" was not injected: check your FXML file 'Travel.fxml'.";

    }

}

