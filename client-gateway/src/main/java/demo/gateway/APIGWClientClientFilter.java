package demo.gateway;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * @author ecabrerar
 * @since Aug 26, 2020
 */
public class APIGWClientClientFilter {

	public String ejecutar() {

		Client client = ClientBuilder.newBuilder().build();

		return client.target(Constantes.ORACLE_CLOUD_FUNCTION_API_GATEWAY)
				.register(FiltroTokenBearer.class).request()
				.get(String.class);

	}

}
