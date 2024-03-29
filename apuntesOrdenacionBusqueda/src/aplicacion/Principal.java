package aplicacion;

import java.util.function.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Principal {

	public static final int INT_MAX = 2147483647;
	public static void main(String[] args) {

		/* INFORMACIÓN DE COMO VA CADA METODO
		 *
		 * TERMINADO:
		 *	Ordenación:
		 * 		- desordenar, burbuja, insercionDirecta,
		 * 	Búsqueda:
		 * 		- busquedaLineal,busquedaLineal2, busquedaBinaria
		 *
		 * EN PROCESO:
		 * 	- seleccionDirecta: Me cambia un 16 por un 0
		 * 	-mergeSort: Me repite numeros
		 *
		 *
		 */


		//Creación de una List<Integer> mediante Supplier
		Supplier<List<Integer>> lista;
		lista = () -> Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
		List<Integer> lista2 = new ArrayList<>();

		Consumer<List<Integer>> addElementos = x -> {
			for (int i = 0; i < 10; i++) {
				x.add((int) (Math.random() * 100) + 1);
			}
			
		};

		//desordenar una List<Integer>
		Consumer<List<Integer>> desordenar = x -> {
			int valor = 0;
			int indice = 0;
			for (int i = 0; i < x.size(); i++) {
				indice = (int) (Math.random() * x.size() - 1);
				valor = x.get(i);
				x.set(i, x.get(indice));
				x.set(indice, valor);
			}
			System.out.println("lista desordenada");
			x.stream().forEach(System.out::println);
			System.out.println("-------------------------------------");
		};

		//Algoritmo de ordenación burbuja o bubbleSort
		Function<List<Integer>, List<Integer>> burbuja = x -> {
			for (int i = 1; i < x.size(); i++) {
				for (int j = x.size() - 1; j >= i; j--) {
					if (x.get(j - 1) > x.get(j)) {
						int valor0 = x.get(j);
						x.set(j, x.get(j - 1));
						x.set(j - 1, valor0);
					}
				}
			}
			return x;
		};

		//Algoritmo de ordenación seleccionDirecta
		Function<List<Integer>, List<Integer>> seleccionDirecta = x -> {
			int menor = 0;
			for (int i = 0; i < x.size(); i++) {
				for (int j = x.size() - 1; j >= i; j--) {
					if (x.get(j) < menor) {
						menor = x.get(j);
						x.set(j, INT_MAX);
					} else if (j == x.size() - 1) {
						x.set(j, menor);
					}
				}
			}
			return x;
		};

		//Algoritmo de ordenación inserccionDirecta
		Function<List<Integer>, List<Integer>> inserccionDirecta = x -> {
			int carta = 0;
			int j = 0;
			for (int i = 1; i < x.size(); i++) {
				carta = x.get(i);
				j = i - 1;
				while (j >= 0 && x.get(j) > carta) {
					x.set(j + 1, x.get(j));
					j--;
				}
				x.set(j + 1, carta);
			}
			return x;
		};

		// ORDENACIÓN:

		//desordenar.accept(lista.get());
		//burbuja.apply(lista.get()).stream().forEach(System.out::println);
		//seleccionDirecta.apply(lista.get()).stream().forEach(System.out::println);
		//inserccionDirecta.apply(lista.get()).stream().forEach(System.out::println);
		//

		//algoritmo de busquedaLineal en una List<Integer>
		BiFunction<List<Integer>, Integer, Integer> busquedaLineal = (x, y) -> {
			for (int i = 0; i < x.size(); i++) {
				if (x.get(i) == y) {
					return i;
				}
			}
			return -INT_MAX;
		};

		BiFunction<Integer[], Integer, Integer> busquedaLineal2 = (x, y) -> {
			int i = 0;
			while (i < x.length && x[i] != y) {
				i++;
			}

			return i < x.length && x[i] == y ? i : -INT_MAX;
		};
		BiFunction<List<Integer>, Integer, Integer> busquedaBinaria = (x, y) -> {
			int izq = 0;
			int der = x.size() - 1;
			int mid = 0;
			while (izq <= der) {
				mid = (der - izq) / 2;
				if (x.get(mid) < y) {
					izq = mid + 1;
				} else if (x.get(mid) > y) {
					der = mid - 1;
				} else if (x.get(mid) == y) {
					return mid;
				}
			}
			return -INT_MAX;
		};

		// BÚSQUEDA:

		//System.out.println(args[0] + " esta en la posicion: " + busquedaLineal.apply(lista.get(), Integer.parseInt(args[0])) + " de la lista");

		//System.out.println(args[0] + " esta en la posicion: " + busquedaBinaria.apply(lista.get(), Integer.parseInt(args[0])) + " de la lista");

		Consumer<List<Integer>> ordenarInsDir= x -> {
		  int carta = 0;
		  int j = 0;
		  for(int i = 1; i<x.size(); i++){
		  carta = x.get(i);
		  j = i -1;
		  while(j>= 0 && x.get(j) > carta){
		  x.set(j+1, x.get(j));
		  j--;
		  }
		  x.set(j+1, carta);
		  }
		  };
		 
		Function<List<Integer>, List<Integer>> mergeSort = x -> {
			List<Integer> izq = x.subList(0, x.size()/2);
			List<Integer> der = x.subList(x.size()/2, x.size());
			ordenarInsDir.accept(izq);
			ordenarInsDir.accept(der);
			//			int j = 0;
			for(int i = 0; i< izq.size(); i++){
				for(int j = 0; j< der.size(); j++){
					//				while(j<der.size()){
					if(izq.get(i) < der.get(j) && !x.contains(i)){
						x.set(i, izq.get(i));
						j++;
						i++;
						//der.remove(j);
						//j++;
					/*}else if(izq.get(i) == der.get(j) && !x.contains(i)){
						x.set(i, izq.get(i));
						//der.remove(j);
						//j++;*/
					}else if(izq.get(i) > der.get(j) && !x.contains(j)){
						x.set(i, der.get(j));
						//der.remove(j);
					}
					}
				}
				return x;
			/*List<Integer> devolver = new ArrayList<>(izq);
			devolver.addAll(der);
			return devolver;*/

			};

			addElementos.accept(lista2);
			System.out.println("La lista es esta:");
			lista2.stream().forEach(System.out::println);
			System.out.println("------------------------------------------");
			mergeSort.apply(lista2).stream().forEach(System.out::println);


			/*desordenar.accept(lista.get());
			quicksort(lista.get(), 0, lista.get().size()-1);
			lista.get().stream().forEach(System.out::println);*/
		}

		//Método de quicksort para ordenar una List<Integer>
		public static void quicksort(List<Integer> L, int izq, int der) {
			//Creo estas variables para poder actualizar los punteros de los limites donde estamos aplicando el algoritmo
			int i = izq;
			int d = der;
			//se declara el elemento pivote, el cual será la mitad de los indices izq y der
			int pivote = L.get((izq + der) / 2);
			//este bucle while iterara hasta que los indices se crucen
			while (i <= d) {
				//El siguiente while compara si el elemento que se situa a la izq es menor que el pivote
				//si lo es, se mueve el puntero un valor a la der
				//y vuelve a iterar, hasta encontrar un elemento mayor o igual que el pivote, el cual cambiaremos
				while (L.get(i) < pivote) {
					i++;
				}
				//El siguiente while compara si el elemento de la der es mayor al pivote
				//Si lo es, se mueve el puntero un valor a la izq
				//y vuelve a iterar, hasta encontrar un elemento menor o igual que el pivote, el cual intercambiaremos
				while (L.get(d) > pivote) {
					d--;
				}

				//teniendo ya los valores de los punteros puestos en elementos que no estan en su sitio, los intercambiamos
				//a no ser que se hayan cruzado, lo cual significaria que ya estan los menores de la lista a la izq, y los mayores a la der
				if (i <= d) {
					int valor = L.get(i);
					L.set(i, L.get(d));
					L.set(d, valor);
					i++;
					d--;
				}
			}
			//Cuando ya se han cruzado los punteros, llamamos al metodo para ordenarlo, pero en un tramo mas pequeño
			if (izq < d) {
				quicksort(L, izq, d);
			} else if (i < der) {
				quicksort(L, i, der);
			}
		}
	}

	//cojo un elemento como pivote(cualquiera) -> muchas veces se pone el central.
	//(3,2,5,9,8,7,6,10,4,6,3,11)
	//Cojo el central ---> 7
	//Izq = busco uno que sea mas grande q el pivote por la izq, me paro en el 9.
	//der = busco un elemento q sea menor o igual que el del pivote por la derecha, me paro en el 3.
	//ahora intercambio los elementos 9 y 3
	//ahora avanzo y hago lo mismo busco uno menor o igual otro mayor y los intercambio
	//cuando se cruzan los indices se hace la particion y se ordenan ambas partes


	//-----------------------------------------------------------------------------------------------------------------

	/*		BiFunction<List<Integer>, Integer, Integer> busquedaBinaria = (x,y) -> {
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
			System.out.println(busquedaBinaria.apply(lista.get(),lista.get().get(2)));*/
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

	//	}
	//}
