package org.themoviedb.api;

import org.themoviedb.api.utils.ErrorResult;
import org.themoviedb.api.utils.HttpRequest;
import org.themoviedb.api.utils.HttpResponse;
import org.themoviedb.api.utils.HttpResponseException;

public class TheMovieDB {
	private String apiKey;
	private final String API_BASE_URL = "https://api.themoviedb.org/3";
	private final String SEARCH_MOVIE_URL = "/search/movie";
	private final String SEARCH_COMPANY_URL = "/search/company";
	
	public TheMovieDB(String apiKey){
		this.apiKey = apiKey;
	}
	
	public SearchMovieResult searchMovie(SearchMovieParameters parameters) throws HttpResponseException{
		try {
			String params = parameters.toString();
			String reqUrl = String.format("%s%s?api_key=%s%s", API_BASE_URL, SEARCH_MOVIE_URL, apiKey, params);
			HttpResponse response = HttpRequest.get(reqUrl);
			
			int responseCode = response.getResponseCode();
			String responseBody = response.getResponseBody();
			if(responseCode == 200){
				return SearchMovieResult.fromJSONString(responseBody);
			}
			else{
				throw new HttpResponseException(ErrorResult.fromJSONString(responseBody));
			}
			
		} catch (Exception e) {
			System.out.println("searchMovie() -> Exception: \n" + e.getMessage());
			return null;
		}
	}
	
	public SearchCompanyResult searhCompany(SearchCompanyParameters parameters) throws HttpResponseException{
		try {
			String params = parameters.toString();
			String reqUrl = String.format("%s%s?api_key=%s%s", API_BASE_URL, SEARCH_COMPANY_URL, apiKey, params);
			HttpResponse response = HttpRequest.get(reqUrl);
			
			int responseCode = response.getResponseCode();
			String responseBody = response.getResponseBody();
			if(responseCode == 200){
				return SearchCompanyResult.fromJSONString(responseBody);
			}
			else{
				throw new HttpResponseException(ErrorResult.fromJSONString(responseBody));
			}
			
		} catch (Exception e) {
			System.out.println("searchCompany() -> Exception: \n" + e.getMessage());
			return null;
		}
	}
}
