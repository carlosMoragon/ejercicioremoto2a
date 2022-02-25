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
			elevarIterativo(10, 2);
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
			}else if(input.equalsIgnoreCase("sumalista")) {
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
			}else if(input.contains("obtenerListaPar")){
				String[] partes = input.split("");
				String numeros = input.substring(input.indexOf("[") + 1 , partes.length -2);
				String[] numerosArray = numeros.split(",");
				obtenerListaPar(numerosArray);
			}else if(input.contains("listaPar")){
				String numero = input.substring(9, input.indexOf(")"));
				System.out.println(numero);
				listaPar(numero);
			}else if(input.equalsIgnoreCase("calcularProductoEscalar")){
				System.out.println("Introduzca el primer vector, con la forma: [1,2,4]");
				String vector1 = sc.nextLine();
				System.out.println("Introduce el segundo vector, con la forma: [3,5,10]");
				String vector2 = sc.nextLine();
				calcularProductoEscalar(obtenerVector(vector1), obtenerVector(vector2));
			}else if(input.contains("Fibonacci(")){
				String numero = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
				System.out.println(terminoFibonacci(Integer.parseInt(numero)));
			}else if(input.equalsIgnoreCase("comparacion")){
				comparacion();
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
			"Sumar números de una lista: 'sumaLista'\n" + 
			"Media de los numeros de una lista: 'media'\n" +
			"Desviacion tipica: 'desviacion'\n" +
			"sumaPares([1,2,3,4])\n" +
			"Filtrar pares de la lista: obtenerListaPar([1,2,3,4])" +
			"Listar los números pares: listarPar([9])\n" +
			"Producto escalar: 'calcularProductoEscalar'\n" +
			"Termino n de la sucesión de Fibonacci: 'Fibonacci(9)'\n";
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

	public static void elevarIterativo(int b, int e){
		long resultado = 1;
		for(int i = 0; i <= e; i++){
			resultado = b * b;
		}
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
		try{
			for(int i = 0; i < lista.length; i++){
				sumaValores += Math.pow((Double.parseDouble(lista[i]) - media),2);

			}
		}catch(NumberFormatException e){
			System.out.println("f");
		}
		double sinRaiz = sumaValores/lista.length;
		desviacion = Math.sqrt(sinRaiz);
		//System.out.println("sumaValores: " + sumaValores + "\nsinRaiz: " + sinRaiz + "\ndesviacion: " + desviacion);
		System.out.println("La media es: " + media + " y la desviación típica es: " + desviacion);
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

	public static void obtenerListaPar(String[] numeros){
		ArrayList<Integer> pares = new ArrayList<>();

		try{
			for(int i = 0; i < numeros.length; i++){
				if(Integer.parseInt(numeros[i]) % 2 ==  0){
					pares.add(Integer.parseInt(numeros[i]));
				}else{
				}
			}
		}catch(NumberFormatException n){
			System.out.println("Se ha producido un error");
		}
		System.out.println(pares);
	}

	public static void listaPar(String numero){
		ArrayList<Integer> pares = new ArrayList<>();
		int n = Integer.parseInt(numero);
		for(int i = 2;i<n;i++){
			if(i % 2 == 0){
				pares.add(i);
			}
		}
		System.out.println(pares);
	}
	
	public static ArrayList<Integer> obtenerVector(String vector){
		ArrayList<Integer> vectorFinal = new ArrayList<>();
		String[] array = vector.split("");
		String paso1 = vector.substring(1,array.length -1);
		String[] paso2 = paso1.split(",");

		for(int i = 0;i<paso2.length;i++){
			vectorFinal.add(Integer.parseInt(paso2[i]));
		}

		return vectorFinal;
	}

	public static void calcularProductoEscalar(ArrayList<Integer> v, ArrayList<Integer> u){
		int solucion = 0;
		for(int i = 0; i < v.size(); i++){
			solucion += v.get(i)*u.get(i);
		}
		System.out.println(solucion);
	}

	public static int terminoFibonacci(int n){
		/*if(n = 0){
		 * 	return 0;
		 * }else if(n == 1){
		 * 	return 1;
		 * }else{
		 * 	return terminoFibonacci(n - 1) + terminoFibonacci(n - 2);
		 * }
		 */
		if(n <= 2){
			return 1;
		}else{
			return terminoFibonacci(n - 1) + terminoFibonacci(n - 2);
		}
	}

	public static void comparacion(){
		double operacion = (1 + Math.sqrt(5))/2;
		double fibonacci = terminoFibonacci(13) / terminoFibonacci(12);
		System.out.println("operacion: " + operacion);
		System.out.println("Fibonacci(13) / Fibonacci(12): " + fibonacci);
		System.out.println("Resta de ambos: " + (operacion - fibonacci));
		
	}
}
