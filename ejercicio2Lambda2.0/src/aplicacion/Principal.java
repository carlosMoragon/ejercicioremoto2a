package aplicacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Principal{
	public static void main(String[] args){
		//Supplier<List<Double>> crea un objeto llamado lista, en el cual se encuentra la coleccion
		Supplier<List<Double>> listaDouble = () -> Arrays.asList(8.9, 4.23, 6.32);
		
		//Para obtener la colección, tenemos que llamar al metodo get(), dado que se encuentra 'dentro'
		//Asi es la diferencia:
		System.out.println(listaDouble);
		System.out.println(listaDouble.get());
		System.out.println("---------------------------------");

		Supplier<List<Integer>> listaInt = () -> Arrays.asList(4,5,6,4,2,6,8);
		System.out.println(listaInt.get());
		sumatorio(/*print, */listaInt.get());
		productorio(/*print, */listaInt.get());
		factorial(9);
	}
	
	public static void sumatorio(/*Consumer<Object> print, */List<Integer> lista){
		int solucion = lista.stream().reduce(0, Integer::sum);
		System.out.println("Sumatorio: " + solucion);
		//print.apply(solucion);
	}

	public static void productorio(/*Consumer<Object> print, */List<Integer> lista){
		int solucion = lista.stream().reduce(1, (x,y) -> x * y);
		//print.apply(solucion);
		System.out.println("Productorio: " + solucion);
		
	}

	public static void factorial(int n){
		int solucion = IntStream.range(1, n).reduce(1, (x, y) -> x * y);
		System.out.println("9!: " + solucion);
	}
	
	public static void media(
}
