package com.example.jimp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    private String fileName;
    public Container container;

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    private int rowNum;
    private int colNum;
    //TODO: nie koniecznie .txt, ale narazie zostawiam ;)
    //TODO: rozpoznawanie złego formatu, bo póki co jeżeli jest zły to tylko pomija ten wierzchołek np: (dobry:    4 :0.213112     zły:   4 0.1231   lub 4 : 12312

    public Reader(String fileName){
        this.fileName = "data/"+fileName+".txt";
    }

    public void readFromFile(){
        BufferedReader reader;
        container = new Container();
        Pattern IntRegex = Pattern.compile("\\d+");
        Pattern IntRegexWithDouble = Pattern.compile("\\d+(\\s)+(\\:)");
        Pattern DoubleRegex = Pattern.compile("\\d+(\\.\\d+)");
        Matcher matcherInt;
        Matcher matcherDouble;
        int i = 0;
        int ifwrong = 0; // jeżeli przeczyta za dużo liczb to coś jest źle
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null){
                if(i ==0){
                    matcherInt = IntRegex.matcher(line);
                    while (matcherInt.find()) {
                        //System.out.println(matcherInt.group());
                        if(ifwrong == 0)
                            rowNum = Integer.parseInt(matcherInt.group());
                        if(ifwrong == 1)
                            colNum = Integer.parseInt(matcherInt.group());
                        ifwrong++;
                        if(ifwrong>2){
                            System.out.println("Zły format pliku!");
                            System.exit(1);
                        }
                    }
                    container.initNodes(rowNum*colNum);
                    ifwrong =0;
                } else {
                matcherInt = IntRegexWithDouble.matcher(line);
                matcherDouble = DoubleRegex.matcher(line);
                while(matcherInt.find() && matcherDouble.find()){

                     //System.out.print( " " + Integer.parseInt( matcherInt.group().replace(" :",""))+" :");
                    // System.out.print(Double.parseDouble(matcherDouble.group()));

                    container.addEgde(i,Integer.parseInt( matcherInt.group().replace(" :","")),Double.parseDouble(matcherDouble.group()));

                    ifwrong++;
                    if(ifwrong > 4){  //IMPORTANT: gdy graf nie jest siatką to ten warunek będzie zły!!!, max 4 połączenia z wierzchołka
                        System.out.println("Zły format pliku!");
                        System.exit(1);
                    }
                }
                ifwrong = 0;
                }
                if(i < rowNum*colNum+1) { // jeżeli doda się enter ( pusty wierzchołek ) na końcu pliku to to się wywoła
                    i++;
                    line = reader.readLine();
                } else{
                    System.out.println("Zły format pliku!");
                    System.exit(1);
                }

            }
            reader.close();
        } catch (IOException e){
            System.out.println("Nie udało sie odnaleźć pliku :(");
        }
     //container.showAll();
    }
}
