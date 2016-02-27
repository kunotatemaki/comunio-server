package com.rukiasoft.server.elpuntal.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rukiasoft.server.elpuntal.classes.Participant;

public class Tools {

	/**
	 * 
	 * @param <T>
	 * @param name nombre del json
	 * @param items array de objetos que queremos añadir al json
	 * @return el json
	 */
	public <T> JsonObject getJSONObjectFromArrayList(String name, List<T> items){
		JsonArray jsonItems = new JsonArray();
		JsonParser parser = new JsonParser();
		for(T item : items){
			Gson object = new Gson();
			JsonObject json = (JsonObject) parser.parse(object.toJson(item));
			jsonItems.add(json);
		}
		JsonObject response = new JsonObject();
		if(jsonItems.size()>0){		
			response.add(name,  jsonItems);
		}
		return response;
	}
}
