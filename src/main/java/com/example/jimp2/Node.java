package com.example.jimp2;

import java.util.Comparator;

public class Node {
    private int number;
    private double cost;

    public Node(int number, double cost) {
        this.number = number;
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }
}
