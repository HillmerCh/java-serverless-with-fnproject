package demo.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.SimpleAuthenticationDetailsProvider;
import com.oracle.bmc.auth.SimplePrivateKeySupplier;
import com.oracle.bmc.functions.FunctionsInvokeClient;
import com.oracle.bmc.functions.requests.InvokeFunctionRequest;
import com.oracle.bmc.functions.responses.InvokeFunctionResponse;
import com.oracle.bmc.util.StreamUtils;
import org.apache.commons.io.IOUtils;

public class ClientOCISDK {

	private String invokeEndpoint;
	private String functionId;

	private String userId;
	private String fingerprint;
	private String pemFilePath;
	private String tenantId;

	private static final Logger logger = LoggerFactory.getLogger( ClientOCISDK.class);


	public ClientOCISDK() {
		try (InputStream inputStream = getClass()
				.getClassLoader().getResourceAsStream("client.properties")) {

			Properties prop = new Properties();
			prop.load(inputStream);
			invokeEndpoint = prop.getProperty("invokeEndpoint");
			functionId = prop.getProperty("functionId");

			userId = prop.getProperty("user");
			fingerprint = prop.getProperty("fingerprint");
			pemFilePath =  getClass().getClassLoader().getResource( prop.getProperty("key_file") ).getPath();
			tenantId = prop.getProperty("tenancy");


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String invokeFunctionApp(String payload) throws IOException {
		System.setProperty( "jdk.tls.client.protocols", "TLSv1.2" );

		AuthenticationDetailsProvider provider
				= SimpleAuthenticationDetailsProvider.builder()
				.tenantId(tenantId)
				.userId(userId)
				.fingerprint(fingerprint)
				.privateKeySupplier(new SimplePrivateKeySupplier( pemFilePath ))
				.build();

		/* use sync client */
		FunctionsInvokeClient functionsInvokeClient = FunctionsInvokeClient.builder()
				.endpoint( invokeEndpoint )
				.build( provider );

		InvokeFunctionRequest request = InvokeFunctionRequest.builder()
				.functionId( functionId )
				.invokeFunctionBody(
						StreamUtils.createByteArrayInputStream( payload.getBytes() )
				)
				.build();

		logger.info( "Invoking the function " );
		InvokeFunctionResponse invokeFunctionResponse = functionsInvokeClient.invokeFunction( request );

		String syncResponse = IOUtils.toString( invokeFunctionResponse.getInputStream(), Charset.defaultCharset() );

		functionsInvokeClient.close();

		return syncResponse;
	}

}
