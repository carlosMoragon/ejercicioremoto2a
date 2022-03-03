package aplicacion;
import java.util.ArrayList;
import interfaz.Interfaz;
public class Principal{
	public static void main(String[] args){
		ArrayList<Integer> lista = new ArrayList<>();
		System.out.println(sumatorio(8, lista));
		/*lista.clear();
		System.out.println(factorial(8, lista));
		lista.clear();*/
	}
/*
	public static ArrayList<Integer> getLista(int n, ArrayList<Integer> lista){
		
		if(n == 1){
			lista.add(n);
			return lista;
		}else{
			lista.add(n);
			return getLista(n - 1, lista);
		}
	}*/

	public static Integer sumatorio(int n, ArrayList<Integer> lista){
		//lista = getLista(n, lista);
		//el metodo reduce va sumando, en este caso, los elementos de la lista, desde 0 hasta lista.size()
		//Este metodo trabaja con flujos de datos; .stream()
		//sintaxis:	.reduce(acumulador, numero)
		Interfaz getLista = (x) -> {
			if(n == 1){
				lista.add(x);
				return lista;
			}else{
				lista.add(x);
				return getLista(x - 1, lista);
			}
		};
		return lista.stream().reduce(0,(x,y) -> x + y);
	}

/*	public static Integer factorial(int n, ArrayList<Integer> lista){
		lista = getLista(n, lista);

		return lista.stream().reduce(1, (x,y) -> x * y);
	}

	public static Integer potencia(int base, int potencia){
	}	*/
}

