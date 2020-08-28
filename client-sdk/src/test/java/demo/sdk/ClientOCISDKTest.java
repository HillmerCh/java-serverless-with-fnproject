package demo.sdk;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClientOCISDKTest {

	private static final Logger logger = LoggerFactory.getLogger( ClientOCISDKTest.class);

	@Test
	void invokeFunctionApp() throws IOException {

		ClientOCISDK clientOCISDK = new ClientOCISDK();
		String result = clientOCISDK.invokeFunctionApp("Hillmer");

		logger.info( result );
		assertNotNull( result );
	}


	@Test
	void invokeFunctionAppManyTimes() throws IOException {

		var list = List.of("Hillmer", "Eudris", "Carlos", "Alex", "Rolando");
		ClientOCISDK clientOCISDK = new ClientOCISDK();
		for(String payload:list) {
			String result = clientOCISDK.invokeFunctionApp( payload );

			logger.info( result );
			assertNotNull( result );
		}
	}
}