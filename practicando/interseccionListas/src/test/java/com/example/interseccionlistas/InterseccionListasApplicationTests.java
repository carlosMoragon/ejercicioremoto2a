package com.example.interseccionlistas;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterseccionListasApplicationTests {
    @Test
    public void test1(){
        List<Integer> solucion = InterseccionListasApplication.interseccionIterativa(Arrays.asList(1,2,3,4,5,6,7,8,9,10), Arrays.asList(1,2,3,4,5,6));
        assertEquals(solucion, Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void test2(){
        List<Integer> solucion = InterseccionListasApplication.interseccionResursiva(Arrays.asList(1,2,3,4,5,6,7,8,9,10), Arrays.asList(1,2,3,4,5,6));
        assertEquals(solucion, Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void test3(){
        List<Integer> solucion = InterseccionListasApplication.interseccionLambda(Arrays.asList(1,2,3,4,5,6,7,8,9,10), Arrays.asList(1,2,3,4,5,6));
        assertEquals(solucion, Arrays.asList(1,2,3,4,5,6));
    }

}
