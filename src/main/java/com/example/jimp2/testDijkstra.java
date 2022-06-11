package com.example.jimp2;

public class testDijkstra {
    public static void main(String [] args){
        Reader reader = new Reader("zupa");
        reader.readFromFile();
        System.out.println("Test Dijkstry:");
        Dijkstra dijkstra = new Dijkstra(reader.container, reader.getRowNum(), reader.getColNum());
        dijkstra.initDijkstra();
        dijkstra.doDijkstra(1,9);
        dijkstra.showPathDij(1,9);
        if(dijkstra.suma==6.222321157370482){
            System.out.println("Test Dijsktry zakończony powodzeniem.");
        }
        else{
            System.out.println("Test Dijkstry zakończony niepowodzeniem.");
        }
    }
}
