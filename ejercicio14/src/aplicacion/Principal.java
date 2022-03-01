package aplicacion;
public class Principal{
	public static void main(String[] args){
		int[] lista = {1, 2, 3, 5, 6, 7};

		int[] lista2 = lista.collect((x) -> x*x);

		lista2.forEach(System.out::println);

		
	}

}
