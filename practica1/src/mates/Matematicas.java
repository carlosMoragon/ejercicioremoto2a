package mates;

import java.lang.Math;

/**
 * @version java 11.0.12 2021-07-20 LTS
 *
 * @author Carlos Moragon Corella.
 *
 * @see en esta clase se realiza el método de montecarlo.
 */

public class Matematicas{
	/**
	 * @param al metodo se le pasa unm parametro de tipo long, el cual le damos el nombre de 'pasos' dicho parametro es el numero total de 'dardos' que se analizan.
	 *
	 * @return el método generarNumeroPiIterativo() devuelve un double, el cual se debe aproximar al numero pi: 3,1416...
	 */
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
