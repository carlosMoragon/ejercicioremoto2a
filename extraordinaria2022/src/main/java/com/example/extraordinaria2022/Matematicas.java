package com.example.extraordinaria2022;

import java.util.List;
import java.util.stream.*;
import java.util.function.*;

public class Matematicas{

    /* RESOLUCIÓN DEL PROBLEMA DE FORMA ITERATIVA */

    public static double babilonicoIterativo(double numero, double errorMaximo){
        return 5.0;
    }

    /* RESOLUCIÓN DEL PROBLEMA DE FORMA RECURSIVA */
    public static double babilonicoRecursivo(double numero, double errorMaximo){
        BaseAltura.base = numero/2; // base inicial
        BaseAltura.altura = 2;

        return babilonicoRecursivo2(numero,errorMaximo);
    }
    private static double babilonicoRecursivo2(double numero, double errorMaximo){
        if(BaseAltura.base == BaseAltura.altura){
            return BaseAltura.base.
        }else{
            siguienteBase(numero);
            return babilonicoRecursivo(numero, errorMaximo);
        }
    }


    /* RESOLUCIÓN DEL PROBLEMA CON EXPRESIONES LAMBDA */
    public static double babilonicoLambda(double numero, double errorMaximo){
        BaseAltura.base = numero/2; // base inicial
        BaseAltura.altura = 2; // altura inicial
        // En Java 6, en lugar de findFirst().orElse(0.0), se utiliza takeWhile(condición).
        // Es decir, findFirst().orElse(0.0) es un artificio para conseguir que, una vez se satisface la condición del filtro, no se sigan generando nuevos elementos.
        // Sólo tiene que modificar el filtro.
        return Stream.generate(() -> siguienteBase(numero)).filter(base -> base == BaseAltura.altura).findFirst().orElse(0.0);
    }

    private static class BaseAltura{
        static double base;
        static double altura;
    }

    private static double siguienteBase(double numero){
        BaseAltura.base = (BaseAltura.base + BaseAltura.altura)/2;
        BaseAltura.altura = numero / BaseAltura.base;

        return BaseAltura.base;
    }
}
