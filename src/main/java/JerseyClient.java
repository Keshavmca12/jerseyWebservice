import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


public class JerseyClient {
	public static void main(String[] args) {
		/*ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);*/
		
		Client client = ClientBuilder.newClient();

		/*WebResource webResource = client
		   .resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String output = response.getEntity(String.class);*/

		
		WebTarget target = client.target(getBaseURI());
		// Get XML
		String xmlResponse = target.path("rest").path("xmlRes").request()
				.accept(MediaType.TEXT_XML).get(String.class);
		// Get XML for application
		String xmlAppResponse =target.path("rest").path("htmlRes").request()
				.accept(MediaType.TEXT_HTML).get(String.class);

		// For JSON response also add the Jackson libraries to your webapplication
		// In this case you would also change the client registration to
		// ClientConfig config = new ClientConfig().register(JacksonFeature.class);
		// Get JSON for application
		// System.out.println(target.path("rest").path("todo").request()
		// .accept(MediaType.APPLICATION_JSON).get(String.class));

		System.out.println(xmlResponse);
		System.out.println(xmlAppResponse);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/jerseyWebService").build();
	}
}
