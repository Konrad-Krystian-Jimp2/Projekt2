package com.example.jimp2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {
    @FXML
    private CheckBox ifGenerate;
    @FXML
    private CheckBox ifRead;
    @FXML
    private CheckBox ifBFS;
    private boolean BFS;

    @FXML
    private Button StartButton;

    @FXML
    private TextField FileNameGen;
    private String fileNameGen;
    private boolean FileNameGenWrong;

    @FXML
    private TextField RowNum;
    private int rowNum;
    private boolean RowNumWrong;

    @FXML
    private TextField ColNum;
    private int colNum;
    private boolean ColNumWrong;


    @FXML
    private TextField FromBoundery;
    private Double fromBoundery;
    private boolean FromBounderyWrong;

    @FXML
    private TextField ToBoundery;
    private Double toBoundery;
    private boolean ToBounderyWrong;

    @FXML
    private TextField FileNameRead;
    private String fileNameRead;
    private boolean FileNameReadWrong;




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FileNameGen.setStyle("-fx-background-color: #fff;");
        FileNameGen.setEditable(false);
        RowNum.setStyle("-fx-background-color: #fff;");
        RowNum.setEditable(false);
        ColNum.setStyle("-fx-background-color: #fff;");
        ColNum.setEditable(false);
        ToBoundery.setStyle("-fx-background-color: #fff;");
        ToBoundery.setEditable(false);
        FromBoundery.setStyle("-fx-background-color: #fff;");
        FromBoundery.setEditable(false);
        FileNameRead.setStyle("-fx-background-color: #fff;");
        FileNameRead.setEditable(false);

    }

    public void setIfGenerate(ActionEvent event) {
        if(ifGenerate.isSelected()){
            ifRead.setDisable(true);

            FileNameGen.setEditable(true);
            FileNameGen.setStyle("-fx-background-insets-color: #fff;");
            RowNum.setEditable(true);
            RowNum.setStyle("-fx-background-insets-color: #fff;");
            ColNum.setEditable(true);
            ColNum.setStyle("-fx-background-insets-color: #fff;");
            ToBoundery.setEditable(true);
            ToBoundery.setStyle("-fx-background-insets-color: #fff;");
            FromBoundery.setEditable(true);
            FromBoundery.setStyle("-fx-background-insets-color: #fff;");
        }
        else {
            ifRead.setDisable(false);

            FileNameGen.setEditable(false);
            FileNameGen.setStyle("-fx-background-color: #fff;");
            FileNameGen.setText("");
            RowNum.setEditable(false);
            RowNum.setStyle("-fx-background-color: #fff;");
            RowNum.setText("");
            ColNum.setEditable(false);
            ColNum.setStyle("-fx-background-color: #fff;");
            ColNum.setText("");
            ToBoundery.setEditable(false);
            ToBoundery.setStyle("-fx-background-color: #fff;");
            ToBoundery.setText("");
            FromBoundery.setEditable(false);
            FromBoundery.setStyle("-fx-background-color: #fff;");
            FromBoundery.setText("");
        }
    }
    public void setIfRead(ActionEvent event) {
        if(ifRead.isSelected()){
            ifGenerate.setDisable(true);

            FileNameRead.setEditable(true);
            FileNameRead.setStyle("-fx-background-insets-color: #fff;");


        }
        else {
            ifGenerate.setDisable(false);

            FileNameRead.setEditable(false);
            FileNameRead.setStyle("-fx-background-color: #fff;");
            FileNameRead.setText("");
        }
    }

    public void setIfBFS(ActionEvent event) {
        if(ifBFS.isSelected()){
            BFS = true;
        }
        else {
            BFS = false;
        }
    }







    public void clickFiledFileNameGenWhenWrong(){
        if(FileNameGenWrong) {
            FileNameGenWrong = false;
            returnToNotWrongView(FileNameGen);
        }
    }

    public void clickFiledRowNumWhenWrong(){
        if(RowNumWrong) {
            RowNumWrong = false;
            returnToNotWrongView(RowNum);
        }
    }

    public void clickFiledColNumWhenWrong(){
        if(ColNumWrong) {
            ColNumWrong = false;
            returnToNotWrongView(ColNum);
        }
    }

    public void clickFiledFromBounderyWhenWrong(){
        if(FromBounderyWrong) {
            FromBounderyWrong = false;
            returnToNotWrongView(FromBoundery);
        }
    }

    public void clickFiledToBounderyWhenWrong(){
        if(ToBounderyWrong) {
            ToBounderyWrong = false;
            returnToNotWrongView(ToBoundery);
        }
    }

    public void clickFiledFileNameReadWhenWrong(){
        if(FileNameReadWrong) {
            FileNameReadWrong = false;
            returnToNotWrongView(FileNameRead);
        }
    }



    private void returnToNotWrongView(TextField n){
        n.setStyle("-fx-text-fill: black;");
        n.setStyle("-fx-background-color: white;");
        n.setStyle("-fx-background-insets-color: #fff;");
    }

    private void setToWrongView(TextField n){
        n.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
    }





    public void onClickButtonStart(ActionEvent event){
        if (ifGenerate.isSelected()){
            if(FileNameGen.getLength()>0 ? FileNameGen.getText().matches("[A-Za-z0-9]+") : false){
                fileNameGen = FileNameGen.getText();
            }
            else {
                setToWrongView(FileNameGen);
                FileNameGenWrong = true;
            }
            if(RowNum.getLength() > 0 && RowNum.getText().matches("[0-9]+") ) {
                    rowNum = Integer.parseInt(RowNum.getText());
                } else {
                    setToWrongView(RowNum);
                    RowNumWrong = true;
                }


            if(ColNum.getLength() > 0 && ColNum.getText().matches("[0-9]+")){
                    colNum = Integer.parseInt(ColNum.getText());
            } else {
                setToWrongView(ColNum);
                ColNumWrong = true;
            }

            if(FromBoundery.getLength() > 0 && FromBoundery.getText().matches("[0-9]+")){
                fromBoundery = Double.parseDouble(FromBoundery.getText());
            } else {
                setToWrongView(FromBoundery);
                FromBounderyWrong = true;
            }

            if(ToBoundery.getLength() > 0 && ToBoundery.getText().matches("[0-9]+")){
                toBoundery = Double.parseDouble(ToBoundery.getText());
            } else {
                setToWrongView(ToBoundery);
                ToBounderyWrong = true;
            }

            if(!ToBounderyWrong && !FromBounderyWrong && ToBoundery.getLength() > 0 && FromBoundery.getLength() > 0){
                if(toBoundery < fromBoundery) {
                    setToWrongView(ToBoundery);
                    ToBounderyWrong = true;
                }
                if(toBoundery < 0){
                    setToWrongView(ToBoundery);
                    ToBounderyWrong = true;
                }
                if(fromBoundery < 0){
                    setToWrongView(FromBoundery);
                    ToBounderyWrong = true;
                }
            }

            if(!FileNameGenWrong && !RowNumWrong && !ColNumWrong && !FromBounderyWrong && !ToBounderyWrong){
                System.out.println( "Generuje graf o parametrach: \n nazwapliku: " +fileNameGen +"\n Ilość wierszy: " +rowNum +"\n Ilość kolumn: " +colNum + "\n Zakres od: " + fromBoundery +" do: " + toBoundery);

                if(BFS){
                    System.out.println("\n + BFS");
                }
            }
        }

        if (ifRead.isSelected()){
            if(FileNameRead.getLength()>0 && FileNameRead.getText().matches("[A-Za-z0-9]+")){
                fileNameRead = FileNameRead.getText();
            }else {
                setToWrongView(FileNameRead);
                FileNameReadWrong = true;
            }

            if(!FileNameReadWrong){
                System.out.println("Wczytuje graf o nazwie:\n "+fileNameRead);
                if(BFS){
                    System.out.println("\n + BFS");
                }
            }
        }




    }

    //TODO: Miejsce na komunikaty, albo obok wprowadznych danych małe TextField'y
    //TODO: Znaczki typu (?) koło rubryk, żeby można było podejrzeć co trzeba wpisać
    //TODO: Jakiś klikalny HELP, większy (?) albo coś w ten deseń
}