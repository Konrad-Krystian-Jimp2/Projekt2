package com.example.jimp2;

public class testGenerator {

    public static void main(String [] args){
        System.out.println("Test generatora:");
        GraphGenerator graphGenerator = new GraphGenerator(10,10,0.2,1,"zupa1", 0.5);

        graphGenerator.graphGen();
        graphGenerator.container.showAll();

        graphGenerator.saveToFile();
        if(graphGenerator.udane){
            System.out.println("Test generatora zakończony powodzeniem.");
        }
        else{
            System.out.println("Test generatora zakończony niepowodzeniem.");
        }

//        Reader reader = new Reader("zupa");
//        reader.readFromFile();

    }
}
