package aplicacion;

import java.util.List;
import java.util.function.Consumer;

public class Principal {
	public static void main(String[] args) {
		List<Integer> L = List.of(1, 6, 4, 2, 5, 13, 51, 3, 10);

		quicksort(L, 0, L.size() - 1);
		L.stream().forEach(System.out::println);

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
			while (L.get(i) < pivote) {
				i++;
			}
			//El siguiente while compara si el elemento de la der es mayor al pivote
			//Si lo es, se mueve el puntero un valor a la izq
			while (L.get(d) > pivote) {
				d--;
			}

			//si
			if (i <= d) {

				int valor = L.get(i);
				L.set(i, L.get(d));
				L.set(d, valor);
				i++;
				d--;
			}
		}

		if (izq < d) {
			quicksort(L, izq, d);
		} else if (i < der) {
			quicksort(L, i, der);
		}
	}
}



