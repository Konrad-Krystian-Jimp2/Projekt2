package com.example.jimp2;

import javafx.geometry.Bounds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    private GraphGenerator graphGenerator = new GraphGenerator(3,3,3,4,"test");

    private boolean ifInBounds(double x){
        if(x > graphGenerator.getFromBound() && x < graphGenerator.getToBound())
            return true;
        else
            return false;
    }

    @Test
    public void RandomTest(){
        double result = graphGenerator.getRandomCost();
        System.out.println(result);
        Assertions.assertTrue(ifInBounds(result));
    }
}
