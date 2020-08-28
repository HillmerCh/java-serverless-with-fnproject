package demo.gateway;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;

/**
 * @author ecabrerar
 * @since Aug 26, 2020
 */
public class FiltroTokenBearer implements ClientRequestFilter{

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		
		String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (null == authHeader) {
			
			String token = UtilToken.getToken().getAccessToken();
		    Logger.getLogger(FiltroTokenBearer.class.getName()).log(Level.INFO,token);
			requestContext.getHeaders().add("Authorization", "Bearer ".concat(token));
			
		}
		
	}

}
