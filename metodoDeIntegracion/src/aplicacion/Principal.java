package aplicacion;
import java.util.function.Function;
public class Principal{
	/**
	 * @see En esta clase se realiza la integral defininida de 1 a 10, de la funcion x^2
	 */
	public static void main(String[] args){
		System.out.println(integral(1, 10, x-> x*x));
		System.out.println(integralNewton(1, 10, x -> x*x));
	}
	
	public static double integral(float a, float b, Function<Float, Float> f){
		//Function <entrada, resultado>
		//Operation <Float> float es tipo de entrada y de resultado
		//
		//metodo apply es para retornar
		float fa = f.apply(a);
		float fb = f.apply(b);
		return (b-a) * (fa + fb)/2;
	}

	public static double integralNewton(float a, float b, Function<Float, Float> f){
		//distancia de punto a punto: b - a /10
		float distancia = (b - a) / 10;
		float altura = 0;
		for(float i = a; i <= b; i += distancia){
			altura += f.apply(i);
		}
		return (b - a) * altura/11;
	}


}
