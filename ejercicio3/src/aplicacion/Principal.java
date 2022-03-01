package aplicacion;
public class Principal{

	private static final TORRE1 = 1;
	private static final TORRE2 = 2;
	private static final TORRE_FINAL = 3;

	public static void main(String[] args){
		//Torres de Hanoi
		System.out.println(torresDeHanoi(Integer.parseInt(args[0])));

	}

	public static long torresDeHanoi(long numeroDiscos){
		long movimientos = 0;
		int i = 0;
		if(numeroDiscos == 1){
			return 1;
		}else{
			return movimientos + 1 + 2 * torresDeHanoi(numeroDiscos - 1);
		}
	}

	public static void recuento(int torre1, int torre2, int torreFinal){

	}

	/*
	 * m1 = 1
	 * m2 = 3
	 * m3 = 
	 */
}
