package aplicacion;
import java.util.ArrayList;
import interfaz.Interfaz;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Principal{
	public static void main(String[] args){
		ArrayList<Integer> lista = new ArrayList<>();
		System.out.println(sumatorio(8, lista));
		lista.clear();
		System.out.println(factorial(8, lista));
		lista.clear();
		System.out.println(potencia(2, 3, lista));
		lista.clear();
		System.out.println(media(15,()-> Math.random()*100, new ArrayList<Supplier<Double>>()));
		lista.clear();
		
	}

	public static ArrayList<Integer> getLista(int n, ArrayList<Integer> lista){
		
		if(n == 1){
			lista.add(n);
			return lista;
		}else{
			lista.add(n);
			return getLista(n - 1, lista);
		}
	}

	public static Integer sumatorio(int n, ArrayList<Integer> lista){
		//el metodo reduce va sumando, en este caso, los elementos de la lista, desde 0 hasta lista.size()
		//Este metodo trabaja con flujos de datos; .stream()
		//sintaxis:	.reduce(acumulador, numero)


		//lista = getLista(n, lista);

		Interfaz lista1 = (x) -> {
			for(int i = 0; i <= x; i++){
				lista.add(i);
			}
			return lista;
		};
		lista1.getLista(n);
		return lista.stream().reduce(0,(x,y) -> x + y);
	}

	public static Integer factorial(int n, ArrayList<Integer> lista){

		lista = getLista(n, lista);

		return lista.stream().reduce(1, (x,y) -> x * y);
	}

	public static Integer potencia(int base, int potencia, ArrayList<Integer> lista){
		//en este caso utilizo el intefaz para añadir la base un total de veces en la lista
		Interfaz lista1 = x -> {
			for(int i = 0; i < potencia; i++){
				lista.add(x);
			}
			return lista;
		};
		lista1.getLista(base);
		return lista.stream().reduce(1,(x,y) -> x * y);
	}

	public static double media(int n, Supplier<Double> s, ArrayList<Supplier<Double>> lista){
		/*
		//generando una lista de numeros aleatorios
		Interfaz lista1 = x -> {
			int numero = 0;
			for(int i = 0; i<= x; i++){
				numero = (int) Math.floor(Math.random()*100);
				lista.add(numero);
			}
			return lista;
		};
		lista1.getLista(n);
				
		System.out.println(lista);
		int media = lista.stream().reduce(0,(x,y) -> x + y);
		return media/lista.size();*/
		for(int i = 0; i<= n; i++){
			lista.add(s);
		}
	//	double media = lista.stream().reduce(0,Double::sum);
		//return media/lista.size();

	}

	public static int desviacion(ArrayList<Integer> lista){
		return 0;
	}
}

