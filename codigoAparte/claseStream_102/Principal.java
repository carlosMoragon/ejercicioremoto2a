import java.util.stream.Stream;
import java.util.Random;
import java.time.LocalDateTime;

/**
 * @author Mariano
 * @author Alvaro
 */

/*
 * Este fichero es la clase del 14/03/2022 de la clase 102. Explican los Stream
 */

public class Principal{
	public static void main(String[] args){
		//-------------------------------------------------------------------------------------------------------------

		// Creación de un `stream` mediante el método `builder()`

		//Parece una clase hija de la clase Stream, llamada Stream.Builder.
		Stream.Builder<Integer> stBuilder = Stream.builder(); // Ingeniero de Caminos Canales y Puertos.
		
		//La clase Stream.Builder es utilizada para construir un Stream de Integers.
		//Los metodos que se han usados son: .add(n); donde n es un Integer. .build(); el cual construye el stream.
		Stream<Integer> st1 = stBuilder.add(1).add(3).add(5).build();
	 	st1.forEach(x -> System.out.print(x + ", "));
	 	System.out.println();	

		//--------------------------------------------------------------------------------------------------------------

		// Creación de un `stream` mediante el método `of()`

		//Inicializamos in Stream, llmando a un metodo de su clase: .of(n,m); donde n y m son Integers.
		Stream<Integer> st2 = Stream.of(1,3,5,7);
	 	st2.forEach(x -> System.out.print(x + ", "));
	 	System.out.println();

		//--------------------------------------------------------------------------------------------------------------

		//Generación de una sucesión en un `stream` a partir de un elemento inicial y utilizando una función
		//En la siguiente linea se llama al método iterate() de la clase Stream:
		//	Stream.iterate('valor inicial', expresion lambda).limit('valor final')
		Stream.iterate(0, x -> x + 1).limit(10).forEach(x -> System.out.print(x + " "));


		//----------------------------------------------------------------------------------------------------------------

		//Generación de un `stream` utilizando un suministrador (_supplier_).

		//Generación de un `stream` con la hora actual.
		//El metodo generate de clase Stream, funciona internamente, mediante Supplier, generando un Stream de la clase introducida:
		//	Stream.generate(Supplier<Clase> ó expresion lambda de Supplier).limit('numero de valores')
		Stream.generate(() -> LocalDateTime.now()).limit(10).forEach(x -> System.out.println(x));
		Stream.generate(() -> LocalDateTime.now()).limit(10).forEach(System.out::println);
		//Generación de un `stream` con la hora actual.
		
		//new Random().nextDouble() genera un numero aleatorio Double, entre el 0.00 y el 1.00.
		//Si le añades el .limit(n) va del 0.00 al n.
		Stream.generate(() -> (new Random()).nextDouble()).limit(10).forEach(System.out::println);
	}
}
