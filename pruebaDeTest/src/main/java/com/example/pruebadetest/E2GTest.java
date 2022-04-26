package com.example.pruebadetest;

import org.junit.jupiter.api.*;

class E2GTest {
    @org.junit.jupiter.api.Test
    void discriminanteCeroTest() {
        Assertions.assertEquals((double) 0, new E2G(2,4,2).discriminante());
    }
    @org.junit.jupiter.api.Test
    void discriminanteUnoTest() {
        Assertions.assertEquals((double) 1, new E2G(2,5,3).discriminante());
    }
    @org.junit.jupiter.api.Test
    void discriminantePositivosTest() {
    }

    @org.junit.jupiter.api.Test
    void discriminanteNegativoTest() {

    }
    @org.junit.jupiter.api.Test
    void RaizDobleTest() {

    }
    @org.junit.jupiter.api.Test
    void x1RaizRealTest() {

    }
    @org.junit.jupiter.api.Test
    void x1RaizImaginariarTest() {

    }
    @org.junit.jupiter.api.Test
    void x2RaizRealTest() {

    }
    @org.junit.jupiter.api.Test
    void x2RaizImaginariaTest() {

    }
    @org.junit.jupiter.api.Test
    void E1GTest() {

    }
}
