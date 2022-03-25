package aplicacion;
import java.util.function.*;
import java.util.List;
import java.util.Arrays;
public class Principal{
	public static void main(String[] args){
		
		Integer[] lista2 = new Integer[Integer.parseInt(args[0])];

		Consumer<Integer[]> lista2a = x ->{
			for(int i = 0; i < x.length; i++){
				x[i] = i + 1;
			}
			
			for(int i = 0; i < x.length; i++){
				int a = (int) (Math.random() * x.length - 1);
				int b = (int) (Math.random() * x.length - 1);
				int valor0 = x[a];
				x[a] = x[b];
				x[b] = valor0;
			}
		};
						
		

 		Function<Integer[], Integer[]> burbujaa = x -> {
                        for(int i = 0; i<x.length - 1; i++){
                                if(x[i] > x[i+1]){
					int valor0 = x[i];
					x[i] = x[i+1];
					x[i+1] = valor0;
                                }
                        }
                        return x;
                };

		lista2a.accept(lista2);

		Integer[] ordenado = burbujaa.apply(lista2);

		Function<Integer[], String> resultado = x -> {
			StringBuilder output = new StringBuilder();
			for(int i = 0; i< x.length; i++){
				output.append(x[i] + "\n");
			}
			return output.toString();
		};


		System.out.println(resultado.apply(ordenado));
		

		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");


		Supplier<List<Integer>> lista = () -> Arrays.asList(2,5,23,3,9,12,43,64,62);
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

		Function<List<Integer>, List<Integer>> seleccionDirecta = x -> {
			int menor = x.get(0);
			for(int n = 0; n <x.size() -1; n++){
				for(int i = 0; i < x.size() - 1; i++){
					if(x.get(i) < menor && i != x.size() - 1){
						menor = x.get(i);
					}else if(i == x.size() - 1){
						x.set(n, menor);
					}
				}
			}
			return x;
		};

		burbuja.apply(lista.get()).stream().forEach(System.out::println);
		System.out.println("----------------------------------");
		seleccionDirecta.apply(lista.get()).stream().forEach(System.out::println);
		
	}
}
