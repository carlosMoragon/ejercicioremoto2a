package aplicacion;
import java.util.function.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Principal{
	public static void main(String[] args){

		/*	int tamanno = Integer.parseInt(args[0]);
			List<Integer> lista2 = new ArrayList<>();

			BinaryOperator<Integer> mayorQue = (x,y) ->{
			if(x > y){
			return x;
			}else{
			return y;
			}
			};

			Consumer<List<Integer>> addTo = x -> {
			System.out.println("Esta es la lista inicial, ordenada");
			for(int i = 0; i< tamanno; i++){
			x.add(i + 1);
			System.out.println(x.get(i));
			}
			System.out.println("-------------------------------------");
			};

			Consumer<List<Integer>> desordenar = x -> {
			int valor = 0;
			int indice = 0;
			for(int i = 0; i <x.size(); i++){
			indice =  (int)(Math.random()*x.size() -1);
			valor = x.get(i);
			x.set(i,x.get(indice));
			x.set(indice,valor);
			}
			System.out.println("lista desordenada");
			x.stream().forEach(System.out::println);
			System.out.println("-------------------------------------");

			};

			Function<List<Integer>,Integer[]> ordenar = x -> {
			Integer[] listaFinal = new Integer[tamanno];
			int mayor = 0;
			for(int i = 0; i < x.size() -1; i++){
			for(int j = x.size() - 1; j > 0; j --){
			mayor = mayorQue.apply(x.get(j), x.get(j - 1));
			if(j == x.size() - 2){
			listaFinal[x.size() - 1] = mayor;
			x.remove(x.get(j));
			}
			}
			}

			return listaFinal;
			};

			addTo.accept(lista2);
			desordenar.accept(lista2);
			System.out.println("lista ordenada");
			Arrays.stream(ordenar.apply(lista2)).forEach(System.out::println);*/





		/*		Consumer<Integer[]> lista2a = x ->{
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
				*/


		Supplier<List<Integer>> lista = () -> Arrays.asList(2,5,23,3,9,12,43,64,62);

		/*		Consumer<List<Integer>> desordenar = x -> {
				int valor = 0;
				int indice = 0;
				for(int i = 0; i <x.size(); i++){
				indice =  (int)(Math.random()*(x.size() -1));
				valor = x.get(i);
				x.set(i,x.get(indice));
				x.set(indice,valor);
				}
				System.out.println("-------------------------------------");
				System.out.println("lista desordenada");
				x.stream().forEach(System.out::println);
				System.out.println("-------------------------------------");
				};
				*/
		Function<List<Integer>, List<Integer>> burbuja = x -> {
			for(int i = 1; i<x.size(); i++){
				for(int j = x.size() - 1; j >= i; j--){
					if(x.get(j-1) > x.get(j)){
						int valor0 = x.get(j);
						x.set(j, x.get(j-1));
						x.set(j-1, valor0);
					}
				}
			}
			return x;
		};

		/*
		   Function<List<Integer>, List<Integer>> seleccionDirecta = x -> {
		   int menor = 0;
		   for(int n = 0; n <x.size(); n++){
		   menor = x.get(x.size() - 1);
		   for(int i = x.size() -1; i >= n; i--){
		   if(x.get(i) < menor && i != x.size() - 1){
		   menor = x.get(i);
		   }else if(i == x.size() - 1){
		   x.set(i, menor);
		   }
		   }
		   }
		   return x;
		   };

		   burbuja.apply(lista.get()).stream().forEach(System.out::println);
		   desordenar.accept(lista.get());
		   seleccionDirecta.apply(lista.get()).stream().forEach(System.out::println);
		   */

		BiFunction<List<Integer>, Integer, Integer> busquedaBinaria = (x,y) -> {
			int izq = 0;
			int der = x.size()-1;
			int mid = 0;
			while(izq <= der){
				mid = (izq + der)/2;
				if(x.get(mid) - y < 0){
					izq = mid + 1;
				}else if(x.get(mid) - y > 0){
					der = mid - 1;
				}else{
					return mid;
				}
			}
			return -1;
		};
		burbuja.apply(lista.get());
		System.out.println(busquedaBinaria.apply(lista.get(),lista.get().get(2)));
		/*		Integer[] lista = new Integer[Integer.parseInt(args[0])];

				Consumer<Integer[]> add = x ->{
				for(int i = 0; i<x.length; i++){
				x[i] = i+1;
				}
				};
				*/
		//En una busqueda tiene 2 argumentos, el array y el elemento que estoy buscando
		/*BiFunction<Integer[], Integer, Integer> busquedaLineal = (x,y) -> {

		  for(int i = 0; i < x.length; i++){
		  if(x[i] == y){
		  return i;
		  }
		  }

		  return -1;

		  };
		  BiFunction<Integer[], Integer, Integer> busquedaLineal2 = (x,y) -> {
		  int i = 0;
		  while(i < x.length && x[i] != y){
		  i++;
		  }

		  return i < x.length && x[i] == y ? i: -INT_MAX;
		//puedo salir del bucle saliendose del array i o encontrando el valor, para filtrarlo  ponemos una condicion.
		//si i< x.length y x[i] = y entonces devuelve i, si no devuelve lo de la derecha: -INT_MAX
		//Es lo mismo que: if(i<x.length && x[i] == y){ return i;}else{return -INT_MAX;}


		};
		int numero = Integer.parseInt(args[0]);
		add.accept(lista);
		System.out.println(busquedaLineal.apply(lista, numero));*/


		//Hecho por JUan cordero
		/*Function<long[], long[]> InserccionDirecta = L -> {
		  for(int i = i; i < L.length; i++){
		  long carta = L[i];
		  int j = i-1;
		  while(j>= 0 && L[j] > carta){
		  L[j + 1] = L[j];
		  j--;
		  }
		  L[j + 1] = carta;
		  }
		  return carta;
		  };*/


		//		burbuja.apply(lista.get()).stream().forEach(System.out::println);
		//		System.out.println("----------------------------------");
		//		seleccionDirecta.apply(lista.get()).stream().forEach(System.out::println);

	}
}
