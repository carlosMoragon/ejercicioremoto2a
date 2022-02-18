package aplicacion;
import java.util.Scanner;
import java.lang.StackOverflowError;
public class Principal{
	public static void main(String[] args){
		int[] array1 = {1, 2, 10, 23};

		System.out.println("Sumatorio: " + sumatorio(8));
		System.out.println("Sumatorio intervalo: " + sumaIntervalo(2,8));
		System.out.println("8!: " + factorial(8));
		System.out.println("2^3: " + potencia(2, 3));
		System.out.println("Suma lista: " + sumaLista(array1, array1.length - 1));
		System.out.println("media de la lista: " + (media(array1, array1.length - 1)/array1.length));
		System.out.println("desviacion de la lista: " + desviacion(array1, array1.length - 1, media(array1, array1.length - 1)/array1.length));
	}
	
	public static int sumatorio(int n){
		if(n == 0){
			return 0;
		}else{
			return n + sumatorio(n - 1);
		}
	}

	public static int sumaIntervalo(int i, int j){
		if(i == j){
			return i;
		}else{
			return i + sumaIntervalo(i + 1, j);
		}
	}

	public static long factorial(int n){
		if(n == 0){
			return 1;
		}else{
			return n * factorial(n -1);
		}
	}

	public static double potencia(int base, int exponente){
		if(exponente == 0){
			return 1;
		}else{
			return base * potencia(base, exponente - 1);
		}
	}

	public static int sumaLista(int[] lista, int i){
		if(i == 0){
			return lista[i];
		}else{
			return lista[i] + sumaLista(lista, i - 1);
		}
	}

	public static int media(int[] lista, int i){
		if(i == 0){
			return lista[i];
		}else{
			return lista[i] + media(lista, i - 1);
		}
	}

	public static double desviacion(int[] lista, int i, double media){
		if(i == 0){
			return potencia(lista[i] - media, 2);
		}else{
			return potencia(lista[i] - media, 2) + desviacion(lista, i - 1, media);
		}
	}

	public static double desviacion(int[] lista){
		return Math.sqrt(desviacion(lista, lista.length - 1, media(lista, lista.length - 1)/lista.length)/lista.length);
	}
}	
