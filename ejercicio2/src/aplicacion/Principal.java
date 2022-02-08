package aplicacion;

import java.util.Scanner;

public class Principal{
	public static void main(String[] args){
		String sentencia = "";

		for(int i = 0; i < args.length; i++){
			sentencia += args[i] + " ";
		}

		if(sentencia.contains("suma")){
			System.out.println("suma");
			String[] partes = sentencia.split(" ");
			suma(Integer.parseInt(partes[1]));
		}else{
			System.out.println("afja");
		}
		/*Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if(input.contains("suma")){
			String[] partes = input.split(" ");
			suma(Integer.parseInt(partes[1]));
		}else{
			System.out.println("El input esta mal");
		}

		if(args[0].equalsIgnoreCase("suma")){
			suma(Integer.parseInt(args[1]));
		}else{
			System.out.println("lajf");
		}*/
	}

	public static void suma(int n){
		long resultado = 0;
		for(int i = 0; i < n; i++){
			resultado += i;
		}
		System.out.println(resultado);
	}
}
