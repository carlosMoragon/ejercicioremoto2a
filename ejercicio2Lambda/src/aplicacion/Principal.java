package aplicacion;
import java.util.ArrayList;
public class Principal{
	public static void main(String[] args){
		ArrayList<Integer> lista = new ArrayList<>();
		System.out.println(sumatorio(8, lista));
	}

	public static ArrayList<Integer> getLista(int n, ArrayList<Integer> lista){
		
		if(n == 1){
			lista.add(n);
			return lista;
		}else{
			lista.add(n);
			return getLista(n - 1, lista);
		}
	}

	public static Integer sumatorio(int n, ArrayList<Integer> lista){
		lista = getLista(n, lista);

		lista.reduce(0,(x,y) -> x + y);

	}
}

