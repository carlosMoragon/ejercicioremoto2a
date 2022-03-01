package aplicacion;
import java.util.Function;
public class Principal{
	public static void main(String[] args){
		integral(1, 10, x->x*x);
	}

	public static double integral(int a, int b, Function<float, float> f){
		//Function <entrada, resultado>
		//Operation <float> float es tipo de entrada y de resultado
		//
		//metodo apply es para retornar
		float fa = f.apply(a);
		float fb = f.apply(b);
		return (b-a) * (fa + fb)/2;
	}


}
