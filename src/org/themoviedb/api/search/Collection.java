package org.themoviedb.api.search;

import org.json.JSONException;
import org.json.JSONObject;

public class Collection {
	private int id;
	private String backdropPath;
	private String name;
	private String posterPath;
	
	public Collection(){
		//
	}
	
	public Collection(int id, String backdropPath, String name, String posterPath){
		this.id = id;
		this.backdropPath = backdropPath;
		this.name = name;
		this.posterPath = posterPath;
		
	}
	
	public static Collection fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int id = jObject.getInt("id");
			String backdropPath = jObject.getString("backdrop_path");
			String name = jObject.getString("name");
			String posterPath = jObject.getString("poster_path");
			
			return new Collection(id, backdropPath, name, posterPath);
		} catch (JSONException e) {
			System.out.println("Collection -> fromJSONString()");
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
	
	//BackdropPath
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	//PosterPath
	public String getPosterPath() {
		return posterPath;
	}
	public void setLogoPath(String posterPath) {
		this.posterPath = posterPath;
	}
}
