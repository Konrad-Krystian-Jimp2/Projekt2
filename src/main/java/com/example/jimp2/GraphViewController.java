package com.example.jimp2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;


public class GraphViewController extends StartScreenController implements Initializable {

    private int rowNum;
    private int colNum;
    private Parent root;
    private Scene scene;



    @FXML
    private AnchorPane backgroundAll;

    @FXML
    private Label text;


    public GraphViewController(){
    }
    public void GraphViewInit(int rowNum, int colNum){

        System.out.println("graphInit: row: " + rowNum + " col:" + colNum);
        this.rowNum = rowNum;
        this.colNum = colNum;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            text.setText("zipa");

    }







    public void PrintGraph(){
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(200);

        circle.setFill(Color.DARKCYAN);
        circle.setStrokeWidth(3.0);
        circle.setStroke(Color.DARKSLATEBLUE);


       // text.setText(Integer.toString(rowNum));
    }


}
