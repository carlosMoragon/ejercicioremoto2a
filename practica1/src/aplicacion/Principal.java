package aplicacion;

import mates.Matematicas;

/**
 * @author anonimo.
 *
 * @see en esta clase se inicializa el método de clase Matematicas, llamado generarNumeroPiIterativo(), con el valor args[0].
 */

public class Principal{
	public static void main(String[] args){
		System.out.println("El número PI es " +
				Matematicas.generarNumeroPiIterativo(Integer.parseInt(args[0])));
	}
}
