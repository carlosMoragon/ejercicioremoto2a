package aplicacion;

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
/*
   import java.io.File;
   import java.
   */
public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		while(repetir){
			System.out.println("-----------------------------");
			String input = sc.nextLine();

			if(input.contains("suma ")){
				String[] numero = input.split(" ");
				suma(Integer.parseInt(numero[1]));
			}else if(input.contains("!")){
				String[] numero = input.split("!");
				factorial(Long.parseLong(numero[0]));
			}else if(input.contains("elevar")){
				String[] numero = input.split(" elevar ");
				elevar(numero[0], numero[1]);
			}else if(input.contains("sumalista")) {
				boolean fallo = true;
				int suma = 0;

				while (fallo) {
					System.out.println("¿Qué números quieres añadir a la lista?");
					String respuesta = sc.nextLine();

					String[] numeros = respuesta.split(", ");

					for (int i = 0; i < numeros.length; i++) {
						try {
							suma += Integer.parseInt(numeros[i]);
							fallo = false;
						} catch (NumberFormatException e) {
							System.out.println("Has introducido un caracter que no es un numero");
							i = numeros.length - 1;
							fallo = true;
						}
					}
				}
				System.out.println(suma);
			}else if(input.equalsIgnoreCase("media")){
				System.out.println("Introduce los números con los que quieras hacer la media");
				String respuesta = sc.nextLine();
				String[] lista = respuesta.split(", ");
				System.out.println(media(lista));
			}else if(input.equalsIgnoreCase("desviacion")){
				System.out.println("Introduce los numeros con los que quieras hallar la desviacion típica");
				String respuesta = sc.nextLine();
				String[] lista = respuesta.split(", ");
				desviacion(lista, media(lista));
			}else if(input.contains("sumaPares")){
				String[] partes = input.split("");
				if(partes[10].equals("[")){
					String sentencia = input.substring(11, partes.length - 2);
					String[] numeros = sentencia.split(",");
					sumaPares(numeros);

				}else{
					String numero = input.substring(10, partes.length - 1);
					sumaPares(Long.parseLong(numero));
				}
			}else if(input.equalsIgnoreCase("help")){
				printHelp();
			}else if(input.equalsIgnoreCase("exit")){
				repetir = false;
			}else{
				printHelp();
				repetir = true;
			}
		}
		sc.close();
	}

	public static void printHelp(){
		String mensaje = "Tienes estas opciones: \n" + 
			"Ayuda: help\n" +
			"Salir: exit\n" +
			"Sumatorio: 'suma' (numero)\n" +
			"Factorial: (numero)!\n" + 
			"Elevar: (numero) elevar (potencia)\n" +
			"\nAl dar los numeros de la lista deben de tener el formato: 2, 4, 10, ...\n" +
			"Sumar números de una lista: 'lista'\n" + 
			"Media de los numeros de una lista: 'media'\n" +
			"Desviacion tipica: 'desviacion'";
		System.out.println(mensaje);
	}


	public static void suma(int n){
		long resultado = 0;
		for(int i = 0; i <= n; i++){
			resultado += i;
		}
		System.out.println(resultado);
	}

	public static void factorial(long n){
		long resultado = 1; 
		for(int i = 1; i<= n; i++){
			resultado *= i;
		}
		System.out.println(resultado);
	}

	public static void elevar(String numero, String potencia){
		double resultado = Math.pow(Double.parseDouble(numero), Double.parseDouble(potencia));
		System.out.println(resultado);
	}
	/*
	   public static void guardarEnFichero(String texto){
	   try{
	   File file = new File("registro");
	   FileWriter fw = new FileWriter(file);

	   }catch(FileNotFoundException f){
	   }
	   }
	   */

	public static double media(String[] lista){
		double media = 0;
		try{
			double suma = 0;
			for(int i = 0; i<lista.length; i++){
				suma += Double.parseDouble(lista[i]);
			}
			media = suma/lista.length;
		} catch (NumberFormatException e) {
		}
		return media;
	}

	public static void desviacion(String[] lista, double media){
		double sumaValores = 0.00;
		double desviacion = 0.00;
		double suma1 = 0.00;
		try{
			for(int i = 0; i < lista.length; i++){
				sumaValores += Double.parseDouble(lista[i]) - media;

			}
		}catch(NumberFormatException e){
		}
		double sinRaiz = sumaValores/lista.length;
		desviacion = Math.pow(sinRaiz, 0.50);
		System.out.println("sumaValores: " + sumaValores + "\nsinRaiz: " + sinRaiz + "\ndesviacion: " + desviacion);
		//System.out.println("La media es: " + media + " y la desviación típica es: " + desviacion);
	}

	public static void sumaPares(long n){
		long suma = 0;
		for(int i = 0; i <= n; i += 2){
			suma += i;
		}
		System.out.println(suma);
	}
	
	public static void sumaPares(String[] lista){
		int suma = 0;
		for(int i = 0; i < lista.length; i++){
			if(Integer.parseInt(lista[i]) % 2 == 0){
				suma += Integer.parseInt(lista[i]);
			}
		}
		System.out.println(suma);
	}
}
