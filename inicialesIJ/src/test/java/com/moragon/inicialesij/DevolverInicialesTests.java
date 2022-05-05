package com.moragon.inicialesij;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevolverInicialesTests {
    @Test
    public void pruebaSimple(){
        assertTrue(DevolverIniciales.devolverIniciales("Carlos, Moragon").equals("C.M"));
    }
    @Test
    public void prueba2Nombres(){
        assertTrue(DevolverIniciales.devolverIniciales("Juan Carlos, Moragon").equals("J.C.M"));
    }
    @Test
    public void prueba2Apellidos(){
        assertTrue(DevolverIniciales.devolverIniciales("Carlos, Moragon Corella").equals("C.M.C"));
    }
    @Test
    public void pruebaComa(){
        assertTrue(DevolverIniciales.devolverIniciales(",").equals(""));
    }
    @Test
    public void pruebaVacia(){
        assertTrue(DevolverIniciales.devolverIniciales("").equals(""));
    }
    @Test
    public void pruebaEspacios(){
        assertTrue(DevolverIniciales.devolverIniciales("   Carlos    ,    Moragon   ").equals("C.M"));
    }
    @Test
    public void pruebaSinNombre(){
        assertTrue(DevolverIniciales.devolverIniciales(", Moragon").equals(""));
    }
    @Test
    public void pruebaSinApellido(){
        assertTrue(DevolverIniciales.devolverIniciales("Carlos,").equals(""));
    }
   /* @Test
    public void pruebaNoString(){
        assertTrue(DevolverIniciales.devolverIniciales("32€, Moragon").equals(""));
    }*/
    @Test
    public void pruebaCompleja(){
        assertTrue(DevolverIniciales.devolverIniciales("     Juan Carlos Jose Santos   , Moragon     Corella Sahuquillo Hurtado").equals("J.C.J.S.M.C.S.H"));
    }
}
