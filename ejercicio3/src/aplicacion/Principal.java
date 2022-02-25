package aplicacion;
public class Principal{
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

	/*
	 * m1 = 1
	 * m2 = 3
	 * m3 = 
	 */
}
