package demo.gateway;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author ecabrerar
 * @since Aug 26, 2020
 */
public class UtilToken {
	
	private UtilToken() {}

	public static Respuesta getToken() {

		MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
		formData.add("client_id", Constantes.CLIENT_ID);
		formData.add("client_secret", Constantes.CLIENT_SECRET);
		formData.add("grant_type", "client_credentials");
		formData.add("scope", Constantes.CLIENT_SCOPE);

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target(Constantes.TOKEN_URL);
				
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(formData,MediaType.APPLICATION_FORM_URLENCODED));

		if (response.getStatus() != 200) {
			throw new ExceptionOGBT("Bad status: " + response.getStatus());
		}

		return response.readEntity(new GenericType<Respuesta>() {});	

	}
	
}
