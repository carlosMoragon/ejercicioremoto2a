package Ppal;

import Modelo.Analizador;
import java.util.Random;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.stream.*;
import java.io.*;
import java.util.Arrays;

/**
 * @author Paloma Centenera
 */
public class AnalisisEmpiricoOrdenacionYBusqueda {
	public static final long LONG_MAX = 2147483647;

	/**
	 * Análisis empírico de los algoritmos de ordenación y búsqueda.
	 * Ejemplares: array de elementos aleatorios, array oredenado y array en orden inverso. Tamaños 100, 1000, 10000, 100000, 1000000, 10000000.
	 * El resultado del análisis, los tiempos de ejecución de los algoritmos para los distintos ejemplares, se graba en el fichero tiempos.txt, en el directorio del proyecto
	 */
	public static void desordena(long[] L){
		Random random=new Random(L.length);
		for (int i=0;i<L.length;i++){
			int p=random.nextInt(L.length);
			long aux=L[i];
			L[i]=L[p];
			L[p]=aux;
		}
	}
	public static long [] quicksort(long[] A, int izq, int der) {

		long pivote=A[izq]; // tomamos primer elemento como pivote
		int i=izq;         // i realiza la búsqueda de izquierda a derecha
		int j=der;         // j realiza la búsqueda de derecha a izquierda
		long aux;

		while(i < j){                          // mientras no se crucen las búsquedas
			while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
			while(A[j] > pivote) j--;           // busca elemento menor que pivote
			if (i < j) {                        // si no se han cruzado
				aux= A[i];                      // los intercambia
				A[i]=A[j];
				A[j]=aux;
			}
		}

		A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
		A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

		if(izq < j-1)
			quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
		if(j+1 < der)
			quicksort(A,j+1,der);          // ordenamos subarray derecho
		return A;
	}
	public static long [] mergesort(long []A,int izq, int der){
		if (izq < der){
			int m=(izq+der)/2;
			mergesort(A,izq, m);
			mergesort(A,m+1, der);
			merge(A,izq, m, der);
		}
		return A;
	}
	public static long[] merge(long []A,int izq, int m, int der){
		int i, j, k;
		long [] B = new long[A.length]; //array auxiliar
		for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar
			B[i]=A[i];

		i=izq; j=m+1; k=izq;

		while (i<=m && j<=der) //copia el siguiente elemento más grande
			if (B[i]<=B[j])
				A[k++]=B[i++];
			else
				A[k++]=B[j++];

		while (i<=m)         //copia los elementos que quedan de la
			A[k++]=B[i++]; //primera mitad (si los hay)
		return A;
	}

	public static void main(String[] args) throws IOException{
		Function<long[], long[]>  BubbleSort = L->
		{
			for (int i = 1; i < L.length; i++)
				for (int j = L.length - 1; j >= i; j--)
					if (L[j - 1] > L[j]) {
						long Aux=L[j];
						L[j]=L[j-1];
						L[j-1]=Aux;
					}
			return L;
		};

		Function<long[], long[]> seleccionDirecta = x -> {
			long menor = 0;
			for (int i = 0; i < x.length; i++) {
				for (int j = x.length - 1; j >= i; j--) {
					if (x[j] < menor) {
						menor = x[j];
						x[j] = LONG_MAX;
						//x.set(j, INT_MAX);
					} else if (j == x.length - 1) {
						x[j] = menor;
						//x.set(j, menor);
					}
				}
			}
			return x;
		};

		Function<long[], long[]> inserccionDirecta = x -> {
			long carta = 0;
			int j = 0;
			for (int i = 1; i < x.length; i++) {
				carta = x[i];
				j = i - 1;
				while (j >= 0 && x[j] > carta) {
					x[j+1] = x[j];
					//x.set(j + 1, x.get(j));
					j--;
				}
				x[j+1] = carta;
				//x.set(j + 1, carta);
			}
			return x;
		};

		BiFunction<long[], Long, Long> busquedaLineal = (x, y) -> {
			for (int i = 0; i < x.length; i++) {
				if (x[i] == y) {
					return (long)i;
				}
			}
			return -LONG_MAX;
		};

		BiFunction<long[], Long, Long> busquedaBinaria = (x, y) -> {
			int izq = 0;
			int der = x.length - 1;
			int mid = 0;
			while (izq <= der) {
				mid = (der - izq) / 2;
				if (x[mid] < y) {
					izq = mid + 1;
				} else if (x[mid] > y) {
					der = mid - 1;
				} else if (x[mid] == y) {
					return (long)mid;
				}
			}
			return -LONG_MAX;
		};
		Function<long[], long[]>  MergeSort = L->
			mergesort(L,0,L.length-1);


		Function<long[], long[]>  QuickSort = L->
			quicksort(L,0,L.length-1);


		long[] [] JuegoPruebasAleatorio =new long[6][];
		long [] []  JuegoPruebasOrdenado =new long[6][];
		long [] []  JuegoPruebasInverso =new long[6][];
		long tam= 10;

		Random random =new Random();

		for (int i=0;i<5;i++){
			JuegoPruebasAleatorio[i]= Stream.iterate( (long) 0, x -> x + 1).limit(tam).mapToLong(x->x).toArray();
			desordena(JuegoPruebasAleatorio[i]);
			JuegoPruebasOrdenado[i]=Stream.iterate( (long) 0, x -> x + 1).limit(tam).mapToLong(x->x).toArray();
			JuegoPruebasInverso[i]=Stream.iterate(tam-1, x -> x - 1).limit(tam).mapToLong(x->x).toArray();
			tam*=10;
		}

		tam=10;
		FileWriter fichero = new FileWriter("tiempos.txt");
		PrintWriter out;

		out= new PrintWriter(fichero);
		long posicion;
		long[] resultado;
		for (int i=0;i<5;i++){
			out.print(tam+"\t");
			System.out.println("tamaño: "+tam);
			System.out.println("Burbuja");

			resultado=Analizador.analiza(JuegoPruebasAleatorio[i],BubbleSort,out);
			//               System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//               System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasOrdenado[i],BubbleSort,out);
			//               System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
			//               System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasInverso[i],BubbleSort,out);
			//              System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
			//              System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();

			/*System.out.println("QuickSort");
			  resultado=Analizador.analiza(JuegoPruebasAleatorio[i],QuickSort,out);
			//             System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//             System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasOrdenado[i],QuickSort,out);
			//             System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
			//             System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasInverso[i],QuickSort,out);
			//            System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();*/

			System.out.println("MergeSort");
			resultado=Analizador.analiza(JuegoPruebasAleatorio[i],MergeSort,out);
			//            System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasOrdenado[i],MergeSort,out);
			//           System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
			//           System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasInverso[i],MergeSort,out);
			//           System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
			//           System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();

			System.out.println("Seleccion directa");
			resultado=Analizador.analiza(JuegoPruebasAleatorio[i],seleccionDirecta,out);
			//            System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasOrdenado[i],seleccionDirecta,out);
			//            System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasInverso[i],seleccionDirecta,out);
			//            System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();


			System.out.println("Insercción directa");
			resultado=Analizador.analiza(JuegoPruebasAleatorio[i],inserccionDirecta,out);
			//            System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasOrdenado[i],inserccionDirecta,out);
			//           System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
			//           System.out.println("ordenado: "+Arrays.toString(resultado));

			resultado=Analizador.analiza(JuegoPruebasInverso[i],inserccionDirecta,out);
			//           System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
			//           System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();
			if(tam < 100000){	
				System.out.println("QuickSort");
				resultado=Analizador.analiza(JuegoPruebasAleatorio[i],QuickSort,out);
				//             System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
				//             System.out.println("ordenado: "+Arrays.toString(resultado));

				resultado=Analizador.analiza(JuegoPruebasOrdenado[i],QuickSort,out);
				//             System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
				//             System.out.println("ordenado: "+Arrays.toString(resultado));

				resultado=Analizador.analiza(JuegoPruebasInverso[i],QuickSort,out);
				//            System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
				//            System.out.println("ordenado: "+Arrays.toString(resultado));
				out.println();
			}

			System.out.println("Busqueda Lineal");
			posicion=Analizador.analizaBusqueda(JuegoPruebasAleatorio[i],random.nextLong(),busquedaLineal,out);
			//             System.out.println("aleatorio: "+Arrays.toString(JuegoPruebasAleatorio[i]));
			//             System.out.println("ordenado: "+Arrays.toString(resultado));

			posicion=Analizador.analizaBusqueda(JuegoPruebasOrdenado[i],random.nextLong(),busquedaLineal,out);
			//             System.out.println("ya ordenado: "+Arrays.toString(JuegoPruebasOrdenado[i]));
			//             System.out.println("ordenado: "+Arrays.toString(resultado));

			posicion=Analizador.analizaBusqueda(JuegoPruebasInverso[i],random.nextLong(),busquedaLineal,out);
			//            System.out.println("inverso: "+Arrays.toString(JuegoPruebasInverso[i]));
			//            System.out.println("ordenado: "+Arrays.toString(resultado));
			out.println();

			tam*=10;
		}
		out.close();


		System.out.print("Fin");
	}
}
