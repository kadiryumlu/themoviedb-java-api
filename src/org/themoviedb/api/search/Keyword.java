package org.themoviedb.api.search;

import org.json.JSONException;
import org.json.JSONObject;

public class Keyword {
	private int id;
	private String name;
	
	public Keyword(){
		//
	}
	
	public Keyword(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public static Keyword fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int id = jObject.getInt("id");
			String name = jObject.getString("name");
			return new Keyword(id, name);
		} catch (JSONException e) {
			System.out.println("Keyword -> fromJSONString()");
			return null;
		}
	}
	
	//Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
