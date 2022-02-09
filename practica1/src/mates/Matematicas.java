package mates;

import java.lang.Math;

public class Matematicas{
	public static double generarNumeroPiIterativo(long pasos){
		double d = 0.00;
		double x;
		double y;
		for(long i = 1; i <= pasos; i++){
			x = Math.random();
			y = Math.random();
			if((Math.pow(x,2) + Math.pow(y,2)) <= 1){
				d++;
			}
		}

		double pi = (4*d)/(double) pasos;

		return pi;
	}
}
