package com.example.interseccionlistas;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterseccionListasApplication<E> {
    public static void main(String[] args) {
        System.out.println(montecarloDonnutLambda(100000));
        System.out.println(montecarloDonnutRecursivo(5000, 0));
        System.out.println(montecarloDonnutLambda(1000000));
    }

    public static List<Integer> interseccionIterativa(List<Integer> lista1, List<Integer> lista2){
        List<Integer> resultado = new ArrayList<>();
        for(int e: lista1){
            for(int i: lista2){
                if(e == i) resultado.add( e);
            }
        }
        /*
        //Implementacion de juan cordero
        for(int e: lista1) if(lista2.contains(e)) resultado.add(e);
         */
        return resultado;
    }
    static List<Integer> solucion = new ArrayList<>();

    public static List<Integer> interseccionResursiva(List<Integer> lista1, List<Integer> lista2){
        if(lista1.isEmpty()||lista2.isEmpty()){
            return solucion;
        }else{
            if(lista2.contains(lista1.get(0))){
                solucion.add(lista1.get(0));
            }
            return interseccionResursiva(lista1.subList(1,lista1.size()),lista2);
        }
    }

    public static List<Integer> interseccionLambda(List<Integer> lista1, List<Integer> lista2){
        return lista1.stream().filter(x -> lista2.contains(x)).collect(Collectors.toList());
    }

    public static long montecarloDonnutLambda(long n){
        long fuera =  Stream.generate(() -> Math.pow(Math.random(), 2) + Math.pow(Math.random(),2)).limit(n).filter(x -> x>=1).filter(x -> x<= 4).count();
        return fuera;
    }

    public static long montecarloDonnutRecursivo(long n, long dentro){
           if(n == 0){
               return dentro;
           }else{
               double x = Math.random();
               double y = Math.random();
               if(x*x+y*y >= 1 && x*x + y*y <= 4){
                   dentro++;
               }
               return montecarloDonnutRecursivo(n-1, dentro);
           }
    }

    public static long montecarlosIterativo(long n){
        long dentro = 0;
        while(n != 0){
            double x = Math.random();
            double y = Math.random();
            if(x*x + y*y >= 1 && x*x + y*y <= 4){
                dentro++;
            }
        }
        return dentro;
    }
}
