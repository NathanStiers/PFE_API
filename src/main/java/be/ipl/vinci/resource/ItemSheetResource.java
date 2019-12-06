package be.ipl.vinci.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import be.ipl.vinci.business.User;

public class ItemSheetResource {
	
	@GET
	@Path("livret")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLivret(User u) {
		return null;
	}

}
