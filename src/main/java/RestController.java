import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class RestController {
	@GET
	@Path("/{param}")
	public String printMessage(@PathParam("param") String msg) {
		System.out.println("here "+msg);
		String result = "Restful example : " + msg;
		return  result;
		//return Response.status(200).entity(result).build();

	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/xmlRes")
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/htmlRes")
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

}
