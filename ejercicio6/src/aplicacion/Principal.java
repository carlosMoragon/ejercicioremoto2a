package aplicacion;
import java.util.function.*;
import java.util.ArrayList;
public class Principal{
	public static void main(String[] args){
		Consumer<Object> print = System.out::println;
		print.accept(sumaCodigos("Carlos"));
	}

	public static int sumaCodigos(String str){ 
		Function<String, ArrayList<Integer>> codigoAscii = x -> {
			String[] array = x.split("");
			ArrayList<Integer> solucion = new ArrayList<>();
			for (int i = 0; i< array.length; i++){
				solucion.add((int) array.charAt(i));
			}
			return solucion;
		};

		ArrayList<Integer> ascii = codigoAscii.apply(str);
		return ascii.stream().reduce(0, Integer::sum);
	}

	
}
