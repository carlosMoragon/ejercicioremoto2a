package aplicacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.function.Consumer;
import java.util.function.Function;
public class Principal{
	public static void main(String[] args){
		//Supplier<List<Double>> crea un objeto llamado lista, en el cual se encuentra la coleccion
		Supplier<List<Double>> listaDouble = () ->  Arrays.asList( 8.9 , 4.23 , 6.32 );
		Consumer<Object> print = System.out::println;
		Function<List<Integer>, Double> function = x -> {
			return (double) x.stream().reduce(0, Integer::sum) / x.size();
		};

		//Para obtener la colección, tenemos que llamar al metodo get(), dado que se encuentra 'dentro'
		//Asi es la diferencia:
		System.out.println(listaDouble);
		System.out.println(listaDouble.get());
		System.out.println("---------------------------------");

		Supplier<List<Integer>> listaInt = () -> Arrays.asList(4,5,6,4,2,6,8,9);
		print.accept(listaInt.get());
		System.out.println(listaInt.get());
		sumatorio(/*print, */listaInt.get());
		productorio(/*print, */listaInt.get());
		factorial(9);
		System.out.println("---------------------------------");
		media(listaInt.get(), print);
		mediaFunction(listaInt.get(), function, print);
	}
	
	public static void sumatorio(/*Consumer<Object> print, */List<Integer> lista){
		//Integer::sum  ==> hace referencia al método sum() de la clase Integer
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
	
	public static void media(List<Integer> lista, Consumer<Object> print){
		int sumaMiembros = lista.stream().reduce(0, Integer::sum);
		int solucion = sumaMiembros/lista.size();
		//El método de Consumer es accept
		print.accept(solucion);
	}

	public static void mediaFunction(List<Integer> lista, Function<List<Integer>, Double> f, Consumer<Object> print){
		print.accept(f.apply(lista));
	}


}
