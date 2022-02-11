package aplicacion;

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		while(repetir){
			System.out.println("-----------------------------");
			String input = sc.nextLine();

			if(input.contains("suma")){
				String[] numero = input.split(" ");
				suma(Integer.parseInt(numero[1]));
			}else if(input.contains("!")){
				String[] numero = input.split("!");
				factorial(Long.parseLong(numero[0]));
			}else if(input.contains("elevar")){
				String[] numero = input.split(" elevar ");
				elevar(numero[0], numero[1]);
			}else if(input.contains("lista")){
				/*long resultado = 0;
				  System.out.println("Añade los numeros que quieras en la lista");
				  boolean annadirMas = true;
				  boolean fallo = true;
				  ArrayList<Integer> lista = new ArrayList<>();
				  while(annadirMas){
				  annadirMas = false;
				  try{
				  int numero = sc.nextInt();
				  lista.add(numero);
				  }catch(InputMismatchException i){
				  System.out.println("di un número");
				//	annadirMas = true;

				  }
				//annadirMas = true;
				System.out.println("¿Quieres añadir más numeros?");
				while(fallo){
				String contestacion = sc.next();

				if(contestacion.equalsIgnoreCase("y")){
				System.out.println("sigue");
				fallo = false;
				annadirMas = true;
				}else if(contestacion.equalsIgnoreCase("n")){
				fallo = false;
				annadirMas = false;
				}else{
				System.out.println("por favor responde 'y' si es un si, o 'n' si es un no.");
				fallo = true;


				}
				}
				  }

				  for(int i = 0; i < lista.size(); i++){
				  resultado += lista.get(i);
				  }
				  System.out.println(resultado);*/
				boolean fallo = true;
				int suma = 0;

				while(fallo){
					System.out.println("¿Qué números quieres añadir a la lista?");
					String respuesta = sc.nextLine();

					String[] numeros = respuesta.split(", ");

					for(int i = 0; i< numeros.length; i++){
						try{
							suma += Integer.parseInt(numeros[i]);
							fallo = false;
						}catch(NumberFormatException e){
							System.out.println("Has introducido un caracter que no es un numero");
							i = numeros.length - 1;
							fallo = true;
						}
					}
				}
				System.out.println(suma);

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
			"Sumar números de una lista: 'lista'\n";
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
	
	public static void guardarEnFichero(String texto){
		File file = new FIle("registro");
		FileWriter fw = new FileWriter(file);
	}
	public static void media(int[] lista){
			
	}

}
