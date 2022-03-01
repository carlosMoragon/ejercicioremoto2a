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
		//Consumidoras: no devuelve resultado
		//	Nombre->System.out.println("Hola " + nombre)
		//Funciones: 
		//
		

		/*INTEFACES:

		En los interfaces son clases abstractas que solo tienen métodos o variables constantes.

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
		
		//Java tiene definido un conjunto de interfaces funcionales, en java.util.*
		//TIPOS:
		//
		//



	}
}
