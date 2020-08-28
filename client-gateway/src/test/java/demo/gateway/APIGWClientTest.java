package demo.gateway;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class APIGWClientTest {

	private final APIGWClient client = new APIGWClient();
	
	@Test
	void testEjecutar() {
		String resultado = client.ejecutar();
		 Logger.getLogger(APIGWClient.class.getName()).log(Level.INFO,resultado);
		assertFalse(resultado.isBlank());
	}

}
