package com.example.jimp2;

import java.util.*;

public class BFS {

    private Container container;
    private int rowNum;
    private int colNum;
    private ArrayList<Integer> visited;
    private HashMap<Integer,Integer> path;
    private HashMap<Integer,Integer> cost;
    private Queue<Integer> queue;

    public BFS(Container container, int rowNum, int colNum){
        this.container = container;
        this.rowNum = rowNum;
        this.colNum = colNum;
        queue = new LinkedList<Integer>();
        visited = new ArrayList<Integer>();
        path = new HashMap<Integer,Integer>();
        cost = new HashMap<Integer,Integer>();
    }

    public boolean doBFS(){
        int start = 1;
        int count = 1;
        visited.add(start);
        queue.add(start);
        cost.put(start,0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Object i : container.Graph.get(node).keySet()){
                if(!visited.contains(i)){
                    queue.add((Integer) i);
                    visited.add((Integer) i);
                    path.put((Integer) i,node);
                    cost.put((Integer) i,cost.get(node)+1);
                    count++;
                }
            }
        }
        if(count == rowNum*colNum){
            System.out.println("Spójny :)");
            return true;
        } else {
            System.out.println("Nie spójny :(");
            return false;
        }
    }

    public void showPathBFS(int from, int to) {
        if (!path.containsKey(from) || !path.containsKey(to) || (to < from)) {
            System.out.println("Drogi nie ma i nie będzie");
        } else {
            try {
                while (to != from) {
                    if (path.containsKey(to)) {
                        int temp = path.get(to);
                        System.out.println(to + "-->" + temp);
                        to = temp;
                    } else {
                        System.out.println("Drogi nie ma i nie będzie");
                        break;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Nie da się odnaleźć drogi");
            }
        }
    }
}
