package be.ipl.vinci;
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



@Path("user")
public class UserResource {
	
	private static User u = new User();
	
	
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(String json) {
		Gson gson = new Gson();
		
		User userRegister = gson.fromJson(json, User.class);
		System.out.println(userRegister.toString());
		if(u.registerUser(userRegister)) {
			
			return Response.status(Response.Status.CREATED).build(); 
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
