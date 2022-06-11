package com.example.jimp2;

public class Testjednostkowycal {
    public static void main(String [] args) {
        System.out.println("Test generatora:");
        GraphGenerator graphGenerator = new GraphGenerator(10, 10, 0.2, 1, "zupa2", 1);

        graphGenerator.graphGen();
        graphGenerator.container.showAll();

        graphGenerator.saveToFile();
        if (graphGenerator.udane) {
            System.out.println("Test generatora zakończony powodzeniem.");
        } else {
            System.out.println("Test generatora zakończony niepowodzeniem.");
        }

        Reader reader = new Reader("zupa2");
        reader.readFromFile();
        System.out.println("Test BFS-a:");
        BFS bfs = new BFS(reader.container, reader.getRowNum(), reader.getColNum());
        bfs.doBFS();
        if (bfs.test == false) {
            System.out.println("Test BFS-a zakończony powodzeniem - graf nie jest spójny");
        } else if (bfs.test == true) {
            System.out.println("Test BFS-a zakończony powodzeniem - graf jest spójny");
        } else {
            System.out.println("Test BFS-a zakończony niepowodzeniem");
        }

        System.out.println("Test Dijkstry:");
        Dijkstra dijkstra = new Dijkstra(reader.container, reader.getRowNum(), reader.getColNum());
        dijkstra.initDijkstra();
        dijkstra.doDijkstra(1, 25);
        dijkstra.showPathDij(1, 25);
        if (dijkstra.suma >= 1.2 && dijkstra.suma <=6) {
            System.out.println("Test Dijsktry zakończony powodzeniem.");
        } else {
            System.out.println("Test Dijkstry zakończony niepowodzeniem.");
        }
    }
}
