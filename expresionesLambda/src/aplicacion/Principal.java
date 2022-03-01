package aplicacion;
public class Principal{
	public static void main(String[] args){
		//Apuntes de expresiones lambda

		//(parametros) -> {Expresion}


		//Si es un lambda de 1 sola linea, no hace falta {}, ni declarar un return
		//Si es un lamba sin parametros se tiene q poner ()

		/*FORMAS:

		()->System.out.println("Hello lambda")

		x->x + 10

		(int x, int y)->{return x + y;}

		(String x, String y)->x.length()-y.length

		(String x)->{
			listA.add(x);
			listB.remove(x);
		}
		*/


		//TIPOS:

		//Productoras: sin argumentos
		//	()->Math.random()*100
		//
		//Consumidoras: no devuelve resultado
		//	Nombre->System.out.println("Hola " + nombre)
		//
		//Funciones:
		//
		//	Operadores Unarios:
		//		(n) -> 1.0/n
		//
		//	Operadores binarios:
		//		(x,y)-> x < y
		

		/*INTEFACES:

		Los interfaces son clases abstractas que solo tienen métodos o variables constantes.

		Interfaces funcionales: son clases abstracta que solo tiene una función publico, pueden tener muchas privadas ----- @FuncionalInterface

		Para la clase hija del interfaz funcional en vez de poner extends, ponemos implements

		*/
		


		/*
		EJEMPLO:

		System.out.println("Mediante clase anidada:" + new hashing(){
			public int hash(String s){
				int sum = 0, i = 1;
				for(char c: s.toCharArray()) sum += c * i++;
				return sum % DIM;
			}}.hash("paloma"));
		*/
		


		//Java tiene definido un conjunto de interfaces funcionales, en java.util.function.*
		//
		//TIPOS:
		//
		//Consumer<T>: t->()
		//	Ejecuta una acción sobre el objeto que se le pasa como argumento
		//	Ejemplo:
		//		x -> System.out.println(x)
		//	import java.util.function.Consumer;
		//
		//Function<T,U>: t -> u
		//	Transforma T a U
		//	Ejemplo:
		//		s -> s.length()
		//	import java.util.function.Function;
		//
		//Supplier: () -> t
		//	Devuelve una instancia de T
		//	Ejemplo:
		//		() -> Math.random() * 100
		//	import java.util.function.Supplier;
		//
		//Predicate <T>:
		//	Una función que devuelve un valor booleano
		//	Ejemplo:
		//		s -> s.length() < 5
		//	import java.util.function.Predicate;

		//MUY IMPORTANTE: LOS INTEFACES TRABAJAN CON LAS CLASES. Si quieres un float, pon la clase Float. Si quieres un int, pon la clase Integer.

	}
}
