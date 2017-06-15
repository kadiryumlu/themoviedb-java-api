package org.themoviedb.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {
	public static HttpResponse get(String url) /*throws HttpResponseException*/{
		URL urlObj;
		HttpURLConnection con;
		int responseCode = 0;
		BufferedReader in;
		StringBuffer response;
		String responseBody = "";
		
		try {
			urlObj = new URL(url);
			con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			responseCode = con.getResponseCode();
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			responseBody = response.toString();
			
			/*if(responseCode != 200){
				throw new HttpResponseException(responseCode);
			}*/
			
		} catch (MalformedURLException e) {
			System.out.println("get() -> MalformedURLException: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("get() -> IOException: \n" + e.getMessage());
		}
		
		return new HttpResponse(responseCode, responseBody);
	}
}
