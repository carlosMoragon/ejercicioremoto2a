package aplicacion;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Principal{
	public static void main(String[] args){
		//Práctica de consumer

		ArrayList<Double> lista = new ArrayList<>();

		lista.add(8.0);
		lista.add(87.0);
		lista.add(3.0);
		lista.add(17.2);
		lista.add(9.102);
		lista.add(0.9);
		/*
		   for(int i = 0; i < 10; i++){
		   double x = Math.random()*100;
		   lista.add(x);
		   }
		   */
		//vamos a realizar la raiz cuadrada de todos los miembros de la lista
		//El metodo .set() permite sustituir el miembro de una lista

		//Consumer<La clase del tipo que queremos aplicar la acción> nombre = "Expresion lambda"
		Consumer<ArrayList<Double>> sqrtConsumer = list -> {
		/*	for(int i = 0; i <lista.size(); i++){
				lista.set(i, Math.sqrt(lista.get(i)));
			}*/
			return list.forEach(x -> Math.sqrt(x));
		};


		Consumer<ArrayList<Double>> print = list -> list.forEach(x -> System.out.println(x));

//		sqrtConsumer(lista);
//		print(sqrtConsumer(lista));
		sqrtConsumer.apply(lista);
		print.apply(lista);

	}
}
