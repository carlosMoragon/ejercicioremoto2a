package com.how2java;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class App {
	private static final double DOUBLE_MAX = 2147483647;

	public static void main( String[] args ){

	}


	public static double mediaArmonica(List<Double> datos){
		double denominador = datos.stream().reduce(0.0, (x,y) -> x + (1/y)).doubleValue();

		if(!datos.contains(0)){
			if(denominador != 0){
				return datos.size()/denominador;

			}else return DOUBLE_MAX;
		}else return 0;
	}
}
