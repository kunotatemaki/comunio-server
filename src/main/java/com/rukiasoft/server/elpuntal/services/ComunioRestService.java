package com.rukiasoft.server.elpuntal.services;

import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rukiasoft.server.elpuntal.classes.Participant;

@Path("services")
public class ComunioRestService {

	
	@GET
	@Path("/get_participants/")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getParticipants() {
		ComunioMethods methods= new ComunioMethods();
		JsonObject response = methods.getParticipantsAsJSON();
		// creacion del json de vuelta
		return Response.status(HttpURLConnection.HTTP_OK).entity(response.toString()).build();
		
	}
	
	@GET
	@Path("/get_page_data/")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getPageData() {
		ComunioMethods methods= new ComunioMethods();
		JsonObject response = methods.getPageDataAsJSON();
		// creacion del json de vuelta
		return Response.status(HttpURLConnection.HTTP_OK).entity(response.toString()).build();
		
	}
	
}
