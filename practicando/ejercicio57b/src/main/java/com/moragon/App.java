package com.moragon;

import java.util.List;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		double solucion = mediaArmonica(new ArrayList<Double>(0.0,2.3,4.2,4.0));
		if(2147483647.0 == solucion){
			System.out.println("Va bien");

		}else System.out.println("Va mal");
	}

	static double mediaArmonica(List<Double> datos){
		if(datos.contains(0)) return 2147483647.0;
		return datos.size() / datos.stream().reduce(0.0, (x,y) -> x + (1/y));
	}

}


