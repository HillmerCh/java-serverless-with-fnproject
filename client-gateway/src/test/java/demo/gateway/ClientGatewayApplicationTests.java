package demo.gateway;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;

public class ClientGatewayApplicationTests {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void should_return_access_token_from_okta() {

		Response response = given().contentType( "application/x-www-form-urlencoded" ).log().all()
				.formParam( "client_id", "<OKTA-CLIENT_ID>" )
				.formParam( "client_secret", "<OKTA-CLIENT_SECRET>" )
				.formParam( "grant_type", "client_credentials" )
				.formParam( "scope", "<OKTA-SCOPE>" )
				.when()
				.post( "https://<OKTA-ACCOUNT>.okta.com/oauth2/default/v1/token" );

		String accessToken = response.getBody().jsonPath().getString( "access_token" );

		assertFalse( accessToken.isEmpty() );

		given()
				.header( "Authorization", "Bearer ".concat( accessToken ) )
				.get( "https://<ORACLE_CLOUD-FUNCTION-API_GATEWAY>" )
				.then().log().all()
				.statusCode( 200 ).body( containsString( "Hello" ) );
	}


	@Test
	public void should_return_access_token_from_oracle_cloud_identity() {

		Response response = given().contentType( "application/x-www-form-urlencoded" ).log().all()
				.formParam( "client_id", "<ORACLE_CLOUD-CLIENT_ID>" )
				.formParam( "client_secret", "<ORACLE_CLOUD-CLIENT_SECRET>" )
				.formParam( "grant_type", "client_credentials" )
				.formParam( "scope", "urn:opc:idm:t.security.client" )
				.when()
				.post( "https://<ORACLE_CLOUD_IDENTITY_MANAGER_ID>.identity.oraclecloud.com/oauth2/v1/token" );

		String accessToken = response.getBody().jsonPath().getString( "access_token" );

		assertFalse( accessToken.isEmpty() );

		given()
				.header( "Authorization", "Bearer ".concat( accessToken ) )
				.get( "https://<ORACLE_CLOUD-FUNCTION-API_GATEWAY>" )
				.then().log().all()
				.statusCode( 200 ).body( containsString( "Hello" ) );

	}
}
