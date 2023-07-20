package com.example.criba_de_eratostones;


import java.util.List;

public class CribaDeEratostonesApplication {

    public static void main(String[] args) {

    }

    public static List<Integer> eratostones(List<Integer> lista){
        int multiplo = lista.size();
        int menor = menor(lista);
        while()
        for(int i : lista){
            for(int j = 0; j<multiplo; j++){
                if(i == menor*j) lista.remove(i);
            }
        }

    }

    public static int menor(List<Integer> lista){
        int menor = Integer.MAX_VALUE;
        for(int i: lista){
            if(i < menor) menor = i;
        }
        return menor;
    }

}
