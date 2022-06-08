package aplicacion;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Principal {
	public static void main(String[] args) {
		LinkedList<String> lista = new LinkedList<String>();

		lista.add("1");
		lista.add("2");
		lista.add("3");


		lista.addAll(Arrays.asList("3","4","5"));
		lista.stream().forEach(System.out::println);
		System.out.println("-------------");
		lista.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

}


