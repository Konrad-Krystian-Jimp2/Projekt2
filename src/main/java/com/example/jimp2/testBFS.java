package com.example.jimp2;

public class testBFS {
    public static void main(String [] args){
        Reader reader = new Reader("zupa");
        reader.readFromFile();
        System.out.println("Test BFS-a:");
        BFS bfs = new BFS(reader.container, reader.getRowNum(), reader.getColNum());
        bfs.doBFS();
        if(bfs.test){
            System.out.println("Test BFS-a zakończony powodzeniem");
        }
        else{
            System.out.println("Test BFS-a zakończony niepowodzeniem");
        }
     //   bfs.showPathBFS(5,100);




    }
}
