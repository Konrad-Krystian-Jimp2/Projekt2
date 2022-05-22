package com.example.jimp2;

import java.util.ArrayList;
import java.util.HashMap;

public class Container {

//    private ArrayList<HashMap> Graph;
//    private HashMap<Integer, Double> NodeConnectWith = new HashMap<Integer, Double>(); // Int -> numer wierzchołka, Double -> koszt przejścia

    private HashMap<Integer,HashMap> Graph;
    private int n; // Liczba wierzchołków

    public Container(){
        Graph = new HashMap<>();
    }

    public void initNodes(int RowTimesCol){
        for(int i =1; i<= RowTimesCol; i++){
            this.addNode(i);
        }
    }

    public void addNode(int LineNum){
        if(!Graph.containsKey(LineNum)) {
            Graph.put(LineNum, new HashMap<Integer, Double>());
            n++;
        }
    }

    public void addEgde(int whichNode, int toNode, double cost){
     //   System.out.println("Graph.get(whichNode): "+Graph.get(whichNode) + "whichNode: " + whichNode + "val of state: " );
        if(!Graph.get(toNode).containsKey(toNode) ) {
            Graph.get(whichNode).put(toNode, cost);
            Graph.get(toNode).put(whichNode, cost);
        }
    }


    public void showAll(){
        for(Integer i : Graph.keySet()){
            System.out.print("Node: " + i +" " );
            for(Object j : Graph.get(i).keySet()){
                System.out.print("-->: " +j + " cost: " + Graph.get(i).get(j) + "\t");

            }
            System.out.println("");
        }
    }

    public int getN(){
        return n;
    }

//    public void addConnectionToNode(Integer nodeNum, Double cost){
//        NodeConnectWith.put(nodeNum, cost);
//    }
//
//    public Double getConnectionToNode(Integer nodeNum){
//        return NodeConnectWith.get(nodeNum);
//    }
//
//    public void removeConnectionToNode(Integer nodeNum){
//        if(n>0) {
//            NodeConnectWith.remove(nodeNum);
//        }
//    }
//
//    public void addNode(int LineNumber){
//        if(n == 0){
//            Graph = new ArrayList<HashMap>();
//        }
//        HashMap<Integer, Double> e = new HashMap<>();
//        Graph.add();
//    }
//
//    public int getN(){
//        return n;
//    }
//
//    public void showAllNodes(){
//        if(n > 0) {
//            for(int j =0; j<)
//            for (Integer i : NodeConnectWith.keySet()) {
//                System.out.println("key: " + i + " value: " + NodeConnectWith.get(i));
//            }
//        } else{
//            System.out.println("Nothing to be shown!");
//        }
//    }
}
