package aplicacion;
import java.util.Scanner;
import java.util.function.Consumer;
public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		procesar(sc.next());

	}

	public static void procesar(String sentencia){
		int numeros = 0;
		int doble = 0;
		int cadena = 0;
		String[] partes = sentencia.split(" ");
		Consumer<Object> comparar = o -> {
				numeros++;
			}else if(o instanceof Double){
				doble++;
			}else{
				cadena++;
			}
		};

		System.out.println("integer " + numeros + "\ndouble " + doble + "\nString " + cadena);
	}
	public static int condicional(Object o){
		if(o instanceof Integer){
			int n
}


