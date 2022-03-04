package aplicacion;
import java.util.ArrayList;
import interfaz.Interfaz;
public class Principal{
	public static void main(String[] args){
		ArrayList<Integer> lista = new ArrayList<>();
		System.out.println(sumatorio(8, lista));
		lista.clear();
		System.out.println(factorial(8, lista));
		lista.clear();
		System.out.println(potencia(2, 3, lista));
		
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
		Interfaz lista1 = x -> {
			for(int i = 0; i < potencia; i++){
				lista.add(x);
			}
			return lista;
		};
		lista1.getLista(base);
		return lista.stream().reduce(1,(x,y) -> x * y);
	}

	public static int media(int[] lista){
		
	}
}

