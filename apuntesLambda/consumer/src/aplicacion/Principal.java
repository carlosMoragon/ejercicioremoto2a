package aplicacion;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
public class Principal{
	public static void main(String[] args){
		//Práctica de consumer

		SupplierArrayList<Double> lista = () -> Arrays.asList(9.2,8.4,23.4);
		/*
		   for(int i = 0; i < 10; i++){
		   double x = Math.random()*100;
		   lista.add(x);
		   }
		   */
		//vamos a realizar la raiz cuadrada de todos los miembros de la lista
		//El metodo .set() permite sustituir el miembro de una lista

		//Consumer<La clase del tipo que queremos aplicar la acción> nombre = "Expresion lambda"
		//Consumer<ArrayList<Double>> sqrtConsumer = list -> list.forEach(x -> Math.sqrt(x));
		/*	for(int i = 0; i <lista.size(); i++){
				lista.set(i, Math.sqrt(lista.get(i)));
			}*/
/*

		Consumer<ArrayList<Double>>sqrtConsumer.apply(lista);
		print.apply(lista);

		Consumer<ArrayList<Double>> print = list -> list.forEach(System.out::println);

//		sqrtConsumer(lista);
//		print(sqrtConsumer(lista));
		
*/
		ArrayList<Double> list = lista
			.stream()
			.map(x -> Math.sqrt(x))
			//.forEach( x -> Math.sqrt(x))
			.forEach(System.out::println);
		
	}
}
