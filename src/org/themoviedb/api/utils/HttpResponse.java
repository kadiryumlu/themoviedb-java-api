package org.themoviedb.api.utils;

public class HttpResponse {
	private int responseCode;
	private String responseBody;
	
	public HttpResponse(int responseCode, String responseBody){
		this.responseCode = responseCode;
		this.responseBody = responseBody;
	}
	
	public int getResponseCode(){
		return this.responseCode;
	}
	
	public String getResponseBody(){
		return this.responseBody;
	}
}
