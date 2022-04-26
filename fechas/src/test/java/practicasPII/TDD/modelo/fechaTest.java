
package practicasPII.TDD.modelo;
import static org.junit.Assert.*;
import org.junit.Test;
public class fechaTest {
	@Test   
	public void manianaTest()
	{
		fecha hoy =new fecha(26,4,2022);	
		fecha m= hoy.maniana();   
		assertTrue(m.dia()==27 && m.mes()==4 && m.anio()==2022);
	}
	
	@Test
	public void mannanaUltimoDiaTest(){
		fecha hoy = new fecha(29,4,2022);
		fecha m= hoy.maniana().maniana();
		assertTrue(m.dia()==1 && m.mes()==hoy.mes()+1 && m.anio()==2022);
	}

	@Test
	public void ultimoDiaTest(){
		fecha hoy = new fecha(30,4,2022);
		fecha m= hoy.maniana();
		assertTrue(m.dia()=1 && m.mes()==hoy.mes()+1 && m.anio()=2022);
	}
	
}
