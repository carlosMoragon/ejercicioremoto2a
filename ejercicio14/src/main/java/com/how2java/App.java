package com.how2java;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class App {
	public static void main( String[] args ){
		Consumer<Object> print = System.out::println;
		Supplier<List<Integer>> lista = () -> Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Predicate<Integer> esPar = x -> x%2 == 0;

		Consumer<List<Integer>> cuadrados = x -> x.stream().map(y->y*y).forEach(System.out::println);

		//cuadrados.accept(lista.get());
		
		Function<List<Integer>, Integer> suma = x ->x.stream().reduce(0, (y,z) -> y + z).intValue();

		//print.accept(suma.apply(lista.get()));

		Function<List<Integer>, Integer> sumaPar = x -> x.stream().filter(esPar).reduce(0, Integer::sum).intValue();
	
		//print.accept(sumaPar.apply(lista.get()));
		
		UnaryOperator<List<Integer>> GlistaPar = x -> x.stream().filter(esPar).collect(Collectors.toList());

		List<Integer> listaPar = GlistaPar.apply(lista.get());

		//listaPar.stream().forEach(System.out::println);



	}
}
