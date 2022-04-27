
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
		fecha m= hoy.maniana();
		assertTrue(m.dia()==30 && m.mes()==4 && m.anio()==2022);
	}

	@Test
	public void mannanaUltimoDiaAnnoTest(){
		fecha hoy = new fecha(30,12,2022);
		fecha m= hoy.maniana();
		assertTrue(m.dia()==31 && m.mes()==12 && m.anio()==2022);
	}
	
	@Test
	public void annoBisiestoTest(){
		fecha hoy = new fecha(29,2,2020);
		assertTrue(hoy.annoBisiesto(hoy) && hoy.dia()==29 && hoy.mes()==2);
	}
}
