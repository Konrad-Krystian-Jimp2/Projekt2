package com.example.jimp2;

import java.util.*;

class ComparatorNode implements Comparator<Node> {
    public int compare(Node o1, Node o2) {
        if(o1.getCost() > o2.getCost())
            return 1;
        else if(o1.getCost() < o2.getCost())
            return -1;
        else
            return 0;
    }
}

public class Dijkstra {
    private Container container;
    private int rowNum;
    private int colNum;
    private int start;
    private int finish;
    private ArrayList<Integer> visited;
    public HashMap<Integer, Integer> path;
    private HashMap<Integer,Double> cost;
    private PriorityQueue<Node> queue;


    public Dijkstra(Container container, int rowNum, int colNum) {
        this.container = container;
        this.rowNum = rowNum;
        this.colNum = colNum;
        queue = new PriorityQueue<Node>(  new ComparatorNode() );
        visited = new ArrayList<Integer>();
        path = new HashMap<Integer, Integer>(); // z --> do
        cost = new HashMap<Integer, Double>();
    }

    public void initDijkstra(){
        for(int i =1; i<=rowNum*colNum; i++){
            cost.put(i,Double.POSITIVE_INFINITY);
        }
    }

    public boolean doDijkstra(int start, int finish)  {
        int last =start;
        visited.add(start);
        cost.put(start,0.0);
        queue.add(new Node(start,0.0));
        while (!queue.isEmpty()) {
            Node gotNode = queue.poll();
            int node = gotNode.getNumber();
            last = node;
            for (Object i : container.Graph.get(node).keySet()) {
                if (!visited.contains(i) && cost.get(i) > ( (Double)container.Graph.get(node).get((Integer) i) + cost.get(node) )) {
                    if(path.containsKey((Integer) i))
                        path.remove((Integer) i);
                    path.put((Integer) i,gotNode.getNumber());
                    cost.put((Integer) i,  gotNode.getCost() + (Double) container.Graph.get(node).get(i));
                    queue.add(new Node((Integer) i,cost.get(node) + (Double) container.Graph.get(node).get(i)));
                    visited.add((Integer) i);
                    if((Integer) i == finish) {
                        System.out.println(path.keySet());
                        System.out.println(path.values());
                        return true;
                    }
                }
            }
        }
        if(last != rowNum*colNum){
            System.out.println("Nie udało się znaleźć drogi :(");
            return false;
        }
        return true;
    }

    public void showPathDij(int from, int to) {
        if(!path.containsKey(to) || to < from){
            System.out.println("Nie da się odnaleźć takiej drogi");
            return;
        }
//        while (from != to) {
//            if(path.containsKey(to) && path.containsKey(path.get(to))) {
//                to = path.get(to);
//            } else  {
//                System.out.println("Nie da się odnaleźć takiej drogi!");
//                return;
//            }
//        }
    try {
        while (from != to) {
                System.out.println(to + " --> " + path.get(to) + " with total cost: " + cost.get(to));
                to = path.get(to);
        }
    }catch (NullPointerException e){
        System.out.println("[dijkstra]: Nie ma takiej drogi");
    }

    }

}
