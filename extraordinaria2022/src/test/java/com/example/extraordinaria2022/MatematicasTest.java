package com.example.extraordinaria2022;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MatematicasTest {
    double delta = 0.01;

    // TESTS PARA LA SOLUCIÓN ITERATIVA

    @Test
    public void raizDe25Lambda() {
        //Observe que se utiliza el parámetro delta porque se está comparando double con double, y el resultado no tiene por qué ser exacto.
        assertEquals(5.0, Matematicas.babilonicoIterativo(25, delta), delta);
    }

    @Test
    public void raizRecursiva(){
        assertEquals(5.0, Matematicas.babilonicoRecursivo(25, delta), delta);
    }
}
