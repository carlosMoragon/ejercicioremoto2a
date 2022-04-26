
package practicasPII.TDD.modelo;
public class fecha {
	private int dia_, mes_, anio_;
	public fecha(int d, int m, int a){
		dia_=d;
		mes_=m;
		anio_=a;
	}
	public int dia(){
		return dia_;
	}
	public int mes(){
		return mes_;
	}
	public int anio(){
		return anio_;
	}
	public fecha maniana(){
		return new fecha(dia_+1,mes_, anio_);
	}
	public fecha mannanaUltimoDiaTest(){
		return new fecha(dia_+1,mes_,anio_);
	}
	public fecha ultimoDiaTest(){
		return new fecha(dia_+1,mes_,anio_);
	}

}
