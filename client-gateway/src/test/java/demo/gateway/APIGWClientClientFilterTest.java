package demo.gateway;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class APIGWClientClientFilterTest {

	private static final APIGWClientClientFilter clientWithFilter = new APIGWClientClientFilter();
	
	@Test
	void testEjecutar() {
		
		String resultado = clientWithFilter.ejecutar();
   	    Logger.getLogger(APIGWClient.class.getName()).log(Level.INFO,resultado);
		
   	    assertFalse(resultado.isBlank());
	}

}
