package aplicacion;

import java.util.Scanner;

public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		while(repetir){
			System.out.println("-----------------------------");
			String suma = sc.nextLine();

			if(suma.contains("suma")){
				String[] numero = suma.split(" ");
				suma(Integer.parseInt(numero[1]));
			}else if(suma.contains("!")){
				String[] numero = suma.split("!");
				factorial(Long.parseLong(numero[0]));
			}else if(suma.equalsIgnoreCase("help")){
				printHelp();
			}else if(suma.equalsIgnoreCase("exit")){
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
			"Factorial: (numero)!\n";
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
}
