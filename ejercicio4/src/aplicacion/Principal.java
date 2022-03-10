package aplicacion;
import java.util.function.*;
import java.util.stream.LongStream;
public class Principal{
	public static void main(String[] args){
		Consumer<Double> print = System.out::println;
		print.accept(integralExCuadrado(0, 8, 0.1));
	}

	double integralEXCuadrado(double limInf, double limSup, double h){
		Predicate<Double> primera = x -> x == limSup;

		Function<Long, Long> factorial = x -> {
			return LongStream.range(1,x).reduce(1, (y, z) -> y * z);
		};



                Function<Long, Double> generarE = x ->{
                        if(x == 0){
                                return 1.0;
                        }else{
                                return 1/factorial.apply(x) + generarE.apply(x - 1);
                        }
                };
		
		double e = generarE.apply((long) 100000);

		UnaryOperator<Double> sumatorio = x -> {
			if(primera.test(x)){
				return 1.0;
			}else{
				return Math.pow(e, x*x) + sumatorio.apply(x - 1);
			}
		};
/*
		Function<Long, Double> generarE = x ->{
			if(x == 0){
				return 1.0;
			}else{
				return 1/factorial.apply(x) + generarE.apply(x - 1);
			}
		};*/

		Supplier<Double> integral = () -> sumatorio.apply(limInf) * h;

		return integral.get();
	}
}
