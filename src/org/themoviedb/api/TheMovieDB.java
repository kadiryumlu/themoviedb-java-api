package org.themoviedb.api;

import org.themoviedb.api.search.*;
import org.themoviedb.api.utils.*;

public class TheMovieDB {
	private String apiKey;
	private final String API_BASE_URL = "https://api.themoviedb.org/3";
	private final String SEARCH_MOVIE_URL = "/search/movie";
	private final String SEARCH_COMPANY_URL = "/search/company";
	private final String SEARCH_COLLECTION_URL = "/search/collection";
	private final String SEARCH_KEYWORD_URL = "/search/keyword";
	
	public TheMovieDB(String apiKey){
		this.apiKey = apiKey;
	}
	
	public SearchCollectionResult searhCollection(SearchCollectionParameters parameters) throws HttpResponseException{
		try {
			String params = parameters.toString();
			String reqUrl = String.format("%s%s?api_key=%s%s", API_BASE_URL, SEARCH_COLLECTION_URL, apiKey, params);
			HttpResponse response = HttpRequest.get(reqUrl);
			
			int responseCode = response.getResponseCode();
			String responseBody = response.getResponseBody();
			if(responseCode == 200){
				return SearchCollectionResult.fromJSONString(responseBody);
			}
			else{
				throw new HttpResponseException(ErrorResult.fromJSONString(responseBody));
			}
			
		} catch (Exception e) {
			System.out.println("searchCollection() -> Exception: \n" + e.getMessage());
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
	
	public SearchKeywordResult searhKeyword(SearchKeywordParameters parameters) throws HttpResponseException{
		try {
			String params = parameters.toString();
			String reqUrl = String.format("%s%s?api_key=%s%s", API_BASE_URL, SEARCH_KEYWORD_URL, apiKey, params);
			HttpResponse response = HttpRequest.get(reqUrl);
			
			int responseCode = response.getResponseCode();
			String responseBody = response.getResponseBody();
			if(responseCode == 200){
				return SearchKeywordResult.fromJSONString(responseBody);
			}
			else{
				throw new HttpResponseException(ErrorResult.fromJSONString(responseBody));
			}
			
		} catch (Exception e) {
			System.out.println("searchCompany() -> Exception: \n" + e.getMessage());
			return null;
		}
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
			System.out.println("searchMovie() -> Exception: \r\n" + e.getMessage());
			return null;
		}
	}
}
