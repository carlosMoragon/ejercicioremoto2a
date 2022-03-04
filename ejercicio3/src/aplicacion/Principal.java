package aplicacion;
public class Principal{
	
	/*private static final String torreOrigen = "Inicio";
	private static final String torreAuxiliar = "Medio";
	private static final String torreDestino = "Final";*/

	public static void main(String[] args){
		torresDeHanoi(Integer.parseInt(args[0]), "inicio", "medio", "final");

	}

	public static void torresDeHanoi(long numeroDiscos, String torreOrigen, String torreAuxiliar, String torreDestino){
		if(numeroDiscos == 1){
			System.out.println(torreOrigen + " a " + torreDestino);
		}else{
			torresDeHanoi(numeroDiscos - 1,torreOrigen, torreDestino, torreAuxiliar);
			mensaje(torreOrigen, torreDestino);
			torresDeHanoi(numeroDiscos - 1, torreAuxiliar, torreOrigen, torreDestino);
		}

	}

	public static void mensaje(String origen, String destino){
		System.out.println(origen + " a " + destino);
	}

	//Hay que darle valores a los discos

}
