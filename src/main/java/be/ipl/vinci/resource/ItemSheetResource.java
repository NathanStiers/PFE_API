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

import be.ipl.vinci.business.Configuration;
import be.ipl.vinci.business.SheetItem;
import be.ipl.vinci.business.User;

@Path("sheetItem")
public class ItemSheetResource {
	
	@GET
	@Path("livret")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLivret(User u) {
		return null;
	}
	
	@POST
	@Path("updateSheetItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSheetItem(String json) {
		
		Gson gson = new Gson();
		SheetItem si = new SheetItem();
		SheetItem itemToUpdate = gson.fromJson(json, SheetItem.class);
		System.out.println(itemToUpdate.toString());
		
		if(si.updateSheetItem(itemToUpdate)) {
			return Response.status(Response.Status.OK).build();
		}else {
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
		
		
		
	}
	
	

}
