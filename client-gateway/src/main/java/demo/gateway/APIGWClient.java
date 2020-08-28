package demo.gateway;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;



/**
 * @author ecabrerar
 * @since Aug 25, 2020
 */
public class APIGWClient {


	public String ejecutar()  {
		
		Client client = ClientBuilder.newBuilder().build();
		
	      return client.target(Constantes.ORACLE_CLOUD_FUNCTION_API_GATEWAY)			             
						.request()
						.header("Authorization", "Bearer ".concat(UtilToken.getToken().getAccessToken()))
						.get(String.class);
	
	

	}	

}
