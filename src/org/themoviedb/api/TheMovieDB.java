package org.themoviedb.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TheMovieDB {
	private String apiKey;
	private final String API_BASE_URL = "https://api.themoviedb.org/3";
	private final String SEARCH_MOVIE_URL = "/search/movie";
	
	public TheMovieDB(String apiKey){
		this.apiKey = apiKey;
	}
	
	private String getRequest(String url){
		URL urlObj;
		HttpURLConnection con;
		int responseCode;
		BufferedReader in;
		StringBuffer response;
		String responseStr = "";
		
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
			responseStr = response.toString();
		} catch (MalformedURLException e) {
			System.out.println("getRequest -> MalformedURLException: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("getRequest -> IOException: \n" + e.getMessage());
		}
		
		return responseStr;
	}
	
	public SearchMovieResult searchMovie(SearchMovieParameters parameters){
		try {
			String params = parameters.toString();
			String reqUrl = String.format("%s%s?api_key=%s%s", API_BASE_URL, SEARCH_MOVIE_URL, apiKey, params);
			//System.out.println(reqUrl);
			String result = getRequest(reqUrl);
			
			return SearchMovieResult.fromJSONString(result);
		} catch (Exception e) {
			System.out.println("searchMovie -> UnsupportedEncodingException: \n" + e.getMessage());
			return null;
		}
	}
}
