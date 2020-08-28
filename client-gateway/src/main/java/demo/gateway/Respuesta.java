package demo.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ecabrerar
 * @since Aug 25, 2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Respuesta {
	
		
	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("expires_in")
	private String expiresIn;
	
	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("token_type")
	private String tokenType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}	
	
}
