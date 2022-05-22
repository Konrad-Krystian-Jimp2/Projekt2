package com.example.jimp2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;



public class GraphViewController {

    private int rowNum;
    private int colNum;
    private Parent root;
    @FXML
    private ScrollPane BackgroundGraph;

    public GraphViewController(int rowNum, int colNum){
        this.rowNum = rowNum;
        this.colNum = colNum;
    }



    public void PrintGraph(){
        Circle circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);
        circle.setRadius(20);

        circle.setFill(Color.DARKCYAN);
        circle.setStrokeWidth(3.0);
        circle.setStroke(Color.DARKSLATEBLUE);
    }
}
