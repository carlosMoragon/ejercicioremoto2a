package aplicacion;
import java.util.function.*;
import java.util.List;
import java.util.Arrays;
public class Principal{
	public static void main(String[] args){

		Function<List<Integer>, List<Integer>> burbuja = x -> {
			for(int i = 0; i<x.size() - 1; i++){
				if(x.get(i)> x.get(i+1)){
					int valor0 = x.get(i);
					int valor1 = x.get(i+1);
					x.set(i, valor1);
					x.set(i+1, valor0);
				}
			}
			return x;
		};

		Supplier<List<Integer>> lista = () -> Arrays.asList(2,5,23,3,9,12,43,64,62);
		
		burbuja.apply(lista.get()).stream().forEach(System.out::println);
	}
}
