package com.example.jimp2;

import java.util.Random;

public class GraphGenerator {

    private int rowNum;
    private int colNum;
    private double fromBound;
    private double toBound;
    private String fileName;
    private boolean Debug;


    private Container container = new Container();

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public double getFromBound() {
        return fromBound;
    }

    public double getToBound() {
        return toBound;
    }

    public String getFileName() {
        return fileName;
    }

    public GraphGenerator(int rowNum, int colNum, double fromBound, double toBound, String fileName){
        this.fileName = fileName;
        this.fromBound = fromBound;
        this.toBound = toBound;
        this.colNum = colNum;
        this.rowNum = rowNum;

        this.Debug = false  ;
    }

    public double getRandomCost(){
        Random random = new Random();
        return random.nextDouble(fromBound, toBound);
    }

    private double getRandomStatement(){
        Random random = new Random();
        return random.nextDouble(0, 3);
    }

    public void graphGen(){
        int RowTimesCol = rowNum * colNum;
        Container container = new Container();
        container.initNodes(RowTimesCol);

        for(int i = 1; i<= RowTimesCol; i++){
            double x=getRandomStatement();//losowanie parametru do wyboru kierunku i ilości ścieżek

            if(i<RowTimesCol-colNum && i%colNum!=0)//węzeł nie znajdujący się na dolnej lub prawej krawędzi
            {
                if(x>=1 && x<1.5)//ścieżka w prawo z aktualnego węzła
                {
                    container.addEgde(i, i+1, getRandomCost());
                }
                if(x>=1.5 && x<2)//ścieżka w dół z aktualnego węzła
                {
                    container.addEgde(i, i+colNum, getRandomCost());
                }
                if(x>=2 && x<3)//obie ścieżki
                {
                    container.addEgde(i, i+1, getRandomCost());
                    container.addEgde(i, i+colNum, getRandomCost());
                }
            }
            if(i%colNum==0 && i<RowTimesCol && x>=0 && x<1.5)//prawa krawędź
                container.addEgde(i, i+colNum, getRandomCost());
            if(i>RowTimesCol-colNum && i<RowTimesCol && x>=0 && x<1.5)//dolna krawędź
                container.addEgde(i, i+1, getRandomCost());

            /*if((i) <= colNum) {
                if( i == 1){
                    if(Debug)   System.out.println(i+ " lewy róg góry siatki");

                    container.addEgde(i,i + 1,getRandomCost());
                    container.addEgde(i,i + colNum,getRandomCost());
                } else if (colNum != 1 ? (i) % (colNum) == 0 : false ) {
                    if(Debug)   System.out.println(i+" prawy róg góry siatki");

                    //container.addEgde(i,i - 1,getRandomCost());
                    container.addEgde(i,i + colNum,getRandomCost());
                } else{
                    if(Debug)   System.out.println(i+" góra siatki");

                    container.addEgde(i,i + 1,getRandomCost());
                    container.addEgde(i,i - 1,getRandomCost());
                    container.addEgde(i,i + colNum,getRandomCost());
                }
            }

            if((i > (RowTimesCol - colNum))){ // doł siatki
                if((i-1)%(colNum) == 0){
                    if(Debug)   System.out.println(i+"lewy róg doł siatki");

                    container.addEgde(i,i+  1,getRandomCost());
                    container.addEgde(i,i - colNum,getRandomCost());
                }else if ( (i)%(colNum) == 0 ){
                    if(Debug)   System.out.println(i+" prawy róg doł siatki");

                    container.addEgde(i,i - 1,getRandomCost());
                    container.addEgde(i,i - colNum,getRandomCost());
                } else {
                    if(Debug)   System.out.println(i+ " dół siatki");

                    container.addEgde(i,i - 1,getRandomCost());
                    container.addEgde(i,i + 1,getRandomCost());
                    container.addEgde(i,i - colNum,getRandomCost());
                }
            }

            if(i > colNum && i <= (RowTimesCol-colNum) ){
                if( (i-1)%(colNum) == 0 ) {
                    if(Debug)   System.out.println(i + "lewy bok siatki");

                    container.addEgde(i,(i - colNum),getRandomCost());
                    container.addEgde(i,(i + colNum),getRandomCost());
                    container.addEgde(i,(i + 1),getRandomCost());
                }else if ( (i)%(colNum) == 0 ){
                    if(Debug)    System.out.println(i+"prawy bok siatki");

                    container.addEgde(i,(i - colNum),getRandomCost());
                    container.addEgde(i,(i + colNum),getRandomCost());
                    container.addEgde(i,(i - 1),getRandomCost());
                } else{
                    if(Debug)    System.out.println(i+ " wnętrze siatki");

                    container.addEgde(i,(i - colNum),getRandomCost());
                    container.addEgde(i,(i + colNum),getRandomCost());
                    container.addEgde(i,(i - 1),getRandomCost());
                    container.addEgde(i,(i + 1),getRandomCost());
                }
            }*/
        }
        System.out.println( container.getN() );
        //container.showAll();

        //dla row i col > 1
//        // ew TODO: row = 1 v col = 1
//        for(int i =0; i< RowTimesCol; i++){
//            if(i-1 < 0 && i - colNum )
//
//        }


    }
}
