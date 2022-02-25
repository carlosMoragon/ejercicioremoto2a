package aplicacion;
public class Principal{
	//técnica de algoritmos acumuladores
	//Funciones recursivas con memoria (en los parametros)
	public static void main(String[] args){
		System.out.println(factorial(1,1,8));
		System.out.println(fibonacci(0,1,1,8));
		System.out.println(sumatorio(0,1,8));
	}

	//i es el siguiente elemento que tenemos que calcular
	//producto es lo que llevamos calculado hasta el momento. Producto actua como acumulador.
	//n es el numero maximo: n!
	public static int factorial(int producto, int i, int n){
		if(i > n){
			return producto;
		}else{
			return factorial(producto * i, i + 1, n);

		}
	}
	
	//anterior es el fibonacci del termino anterior
	//actual es el acumulador, y el termino actual
	//temino es el termino de fibonacci que se esta calculando
	//n es el termino que queremos alcanzar
	public static int fibonacci(int anterior, int actual, int termino, int n){
		if(termino == n){
			return actual;
		}else{
			//el actual siguiente es actual + anterior dado que seria: n = n -2 + n - 1
			return fibonacci(actual, actual + anterior, termino + 1, n);
		}
	}
	
	//suma es el acumulador, que es lo que llevamos sumado
	//i es el numero por el que vamos sumando
	//n es el numero hasta el que se tiene que hacer el sumatorio
	public static int sumatorio(int suma, int i, int n){
		if(i == n){
			return suma;
		}else{
			return sumatorio(suma + i, i + 1, n);
		}
	}
}
