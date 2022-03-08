package aplicacion;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
public class Principal{
	public static void main(String[] args){
		//Supplier<List<Double>> lista devuelve un List<Double> llamado lista
		Supplier<List<Double>> lista = () -> Arrays.asList(8.9, 4.23, 6.32);

		System.out.println(lista);
	}

}
