package sakilaApp.utils;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class FuncionsUtilsTest {

	@Test
	public void provaSumaRetornaSumaCorrectament() {
		//GIVEN
		int numA=10;
		int numB=10;
		//WHEN
		int resultat = FuncionsUtils.provaSuma(numA,numB);
	
		//THEN
		assertEquals(22,resultat,"S'esperava que fossin iguals");
	}
	
	@Test
	public void provaSumaRetornaSumaParellsCorrectament() {
		//GIVEN
		int numA=10;
		int numB=10;
		//WHEN
		try {
			int resultat = FuncionsUtils.provaSumaSiParells(numA,numB);

			//THEN
			assertEquals(20,resultat,"S'esperava que fossin iguals");
			
		}catch(Exception ex) {
			fail("Ha generat excepció");
		}
	
	}
	
	@Test
	public void provaSumaParellsFallaQuanUnImparell() {
		//GIVEN
		int numA=11;
		int numB=10;
		//WHEN
		try {
			int resultat = FuncionsUtils.provaSumaSiParells(numA,numB);

			//THEN
			assertEquals(20,resultat,"S'esperava que fossin iguals");
			
		}catch(Exception ex) {
			fail("Ha generat excepció");
		}
	
	}
	
	@Test
	public void provaSumaSiParellsLlancaExceptionQuanNombreAImparell() {
		//GIVEN
		int numA=12;
		int numB=10;
		//WHEN
		//THEN
		assertThrows(Exception.class, () -> { FuncionsUtils.provaSumaSiParells(numA,numB);},"Hauria de llançar exception si un nombre no és parell");
	
		
	}
	
}
