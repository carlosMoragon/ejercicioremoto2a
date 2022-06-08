package aplicacion;
import java.util.List;
import java.util.Arrays;

public class Principal {
	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.println(mediaArmonica(Arrays.asList(0.0,2.3,3.5)));
		System.out.println("---------------------------------------");
		System.out.println(mediaArmonica(Arrays.asList(5.0,2.3,3.5)));	
		System.out.println("---------------------------------------");
		System.out.println(mediaArmonica(Arrays.asList(-3.5,3.5)));	
		System.out.println("---------------------------------------");
	}

	public static double mediaArmonica(List<Double> datos){
		if(datos.contains(0.0)){
			return Double.MAX_VALUE;
		}else{
			return datos.size()/ datos.stream().reduce(0.0, (x,y) -> x + (1/y));
		}
	}

}


