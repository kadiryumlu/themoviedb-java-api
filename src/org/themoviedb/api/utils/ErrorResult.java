package org.themoviedb.api.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorResult {
	private int statusCode;
	private String statusMessage;
	
	public ErrorResult(){
		
	}

	public ErrorResult(int statusCode, String statusMessage){
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	
	public static ErrorResult fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int statusCode = jObject.getInt("status_code");
			String statusMessage = jObject.getString("status_string");
			
			return new ErrorResult(statusCode, statusMessage);
		} catch (JSONException e) {
			System.out.println("SearchMovieResult");
			return null;
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public int getStatusCode(){
		return this.statusCode;
	}
	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}
	
	public String getStatusMessage(){
		return this.statusMessage;
	}
	public void setStatusMessage(String statusMessage){
		this.statusMessage = statusMessage;
	}
}