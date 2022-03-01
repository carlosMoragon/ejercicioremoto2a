package aplicacion;
public class Principal{

	private static final String torreOrigen = "Inicio";
	private static final String torreAuxiliar = "Medio";
	private static final String torreDestino = "Final";

	public static void main(String[] args){
		torresDeHanoi(Integer.parseInt(args[0]), Integer.parseInt(args[0]), 0, 0);

	}

	public static void torresDeHanoi(long numeroDiscos, int origen, int auxiliar, int destino){
		if(numeroDiscos == 1){
			System.out.println(torreOrigen + " a " + torreDestino);
		}else{
			System.out.println(torreOrigen + " a " + torreAuxiliar);
			torresDeHanoi(numeroDiscos - 1, origen - 1, auxiliar + 1, destino);
		}

	}

}
