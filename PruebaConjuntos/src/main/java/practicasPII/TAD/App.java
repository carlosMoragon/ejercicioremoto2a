package practicasPII.TAD;
import java.util.*;
public class App 
{
	public static boolean feliz(int n){
		//HashSet es una implementacion de la interfaz Set.
		//HashSet es un conjunto.
		HashSet<Integer> c=new HashSet<Integer>();
		int suma=0, d;
		System.out.print(n) ; 
		while (n!=1 && !c.contains((Integer) n)){
			c.add((Integer) n);
			suma=0;
			while (n>0){
				d=n%10;
				suma+=d*d;
				n/=10;
			}
			n=suma;
			System.out.print ("-->"+n);
		}
		return n==1;
	} 
	public static void main( String[] args )
	{
		int n=50;
		System.out.println( " El número "+n+" es feliz: "+feliz(n) );
	}
}
