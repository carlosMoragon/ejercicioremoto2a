package aplicacion;
import java.util.function.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Principal{
	static final int INT_MAX = 2147483647;
	public static void main(String[] args){

		/* INFORMACIÓN DE COMO VA CADA METODO
		 *
		 * TERMINADO: 
		 *	Ordenación:
		 * 		- desordenar, burbuja, insercionDirecta,
		 * 	Búsqueda:
		 * 		- busquedaLineal,
		 *
		 * EN PROCESO:
		 * 	- seleccionDirecta: Me cambia un 16 por un 0
		 *
		 *
		 */
		

		//Creación de una List<Integer> mediante Supplier
		Supplier<List<Integer>> lista = () -> Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		
		//desordenar una List<Integer>
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

		//Algoritmo de ordenación burbuja
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

		//Algoritmo de ordenación seleccionDirecta
		Function<List<Integer>, List<Integer>> seleccionDirecta = x -> {
			int menor = 0;
			for(int i = 0; i<x.size(); i++){
				for(int j = x.size() -1; j>= i; j--){
					if(x.get(j) < menor){
						menor = x.get(j);
						x.set(j, INT_MAX);
					}else if(j == x.size()-1){
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
			for(int i = 1; i<x.size(); i++){
				carta = x.get(i);
				j = i -1;
				while(j>= 0 && x.get(j) > carta){
					x.set(j+1, x.get(j));
					j--;
				}
				x.set(j+1, carta);
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
		BiFunction<List<Integer>, Integer, Integer> busquedaLineal = (x,y) -> {
			for(int i = 0; i<x.size(); i++){
				if(x.get(i) == y){
					return i;
				}
			}
			return -INT_MAX;
		};

		// BÚSQUEDA:
		 
		//System.out.println(args[0] + " esta en la posicion: " + busquedaLineal.apply(lista.get(), Integer.parseInt(args[0])) + " de la lista");
		
		//

	}
}
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
