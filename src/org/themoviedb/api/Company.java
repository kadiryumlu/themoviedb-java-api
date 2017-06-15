package org.themoviedb.api;

import org.json.JSONException;
import org.json.JSONObject;

public class Company {
	private int id;
	private String logoPath;
	private String name;
	
	public Company(){
		//
	}
	
	public Company(int id, String logoPath, String name){
		this.id = id;
		this.logoPath = logoPath;
		this.name = name;
	}
	
	public static Company fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int id = jObject.getInt("id");
			String logoPath = jObject.getString("logo_path");
			String name = jObject.getString("name");
			return new Company(id, logoPath, name);
		} catch (JSONException e) {
			System.out.println("Company -> fromJSONString()");
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
	
	//LogoPath
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
