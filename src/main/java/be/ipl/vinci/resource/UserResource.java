package be.ipl.vinci.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import be.ipl.vinci.business.User;



@Path("user")
public class UserResource {
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(String json) {
		System.out.println("test register");
		Gson gson = new Gson();
		User u = new User();
		User userRegister = gson.fromJson(json, User.class);
		System.out.println(userRegister.toString());
		if(u.registerUser(userRegister)) {
			return Response.status(Response.Status.CREATED).build(); 
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@POST
	@Path("connection")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response connectUser(String json) {
		System.out.println("test connection");
		Gson gson = new Gson();
		User u = new User();
		User userToConnect = gson.fromJson(json, User.class);
		System.out.println(userToConnect.toString());
		if(u.connectUser(userToConnect)) {
			return Response.status(Response.Status.OK).build(); 
		}else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/info/{code}")
	public Response getInfo(@PathParam("code") String code) {
		Gson gson = new Gson();
		User u = new User();
		String json = gson.toJson(u.getAllInfo(code));
		System.out.println(json);
		
		
		return Response.status(Response.Status.OK).entity(json).build();
	}
	

}
