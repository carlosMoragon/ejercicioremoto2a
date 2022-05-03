package aplicacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class Principal {
	public static void main(String[] args) {
		//algoritmo de mergesort
		List<Integer> lista = Arrays.asList(12,3,4,5,6,7,8,9,10,11,1,2);

		System.out.println("Lista original: " + lista);

		Supplier<List<Integer>> mergeSort = () -> {
			List<Integer> listaOrdenada = lista;
			mergeSort(listaOrdenada, 0, listaOrdenada.size() - 1);
			return listaOrdenada;
		};

		System.out.println("Lista ordenada: " + mergeSort.get());

		//algoritmo de timsort
		lista = Arrays.asList(12,3,4,5,6,7,8,9,10,11,1,2);

		System.out.println("Lista original: " + lista);

	}



	private static void mergeSort(List<Integer> lista, int inicio, int fin) {
		if (inicio < fin) {
			int mitad = (inicio + fin) / 2;
			mergeSort(lista, inicio, mitad);
			mergeSort(lista, mitad + 1, fin);
			merge(lista, inicio, mitad, fin);
		}
	}

	private static void merge(List<Integer> lista, int inicio, int mitad, int fin) {
		int i = inicio;
		int j = mitad + 1;
		int k = 0;

		int[] aux = new int[fin - inicio + 1];

		while (i <= mitad && j <= fin) {
			if (lista.get(i) <= lista.get(j)) {
				aux[k] = lista.get(i);
				i++;
			} else {
				aux[k] = lista.get(j);
				j++;
			}
			k++;
		}

		while (i <= mitad) {
			aux[k] = lista.get(i);
			i++;
			k++;
		}

		while (j <= fin) {
			aux[k] = lista.get(j);
			j++;
			k++;
		}

		for (int l = 0; l < aux.length; l++) {
			lista.set(inicio + l, aux[l]);
		}
	}
}


