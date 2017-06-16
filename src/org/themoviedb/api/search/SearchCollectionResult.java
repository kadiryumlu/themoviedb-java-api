package org.themoviedb.api.search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchCollectionResult {
	private int page;
	private Collection[] results;
	private int totalResults;
	private int totalPages;
	
	public SearchCollectionResult(){
		
	}
	
	public static SearchCollectionResult fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int page = jObject.getInt("page");
			Collection[] results = toCollectionArray(jObject.getJSONArray("results"));
			int totalResults = jObject.getInt("total_results");
			int totalPages = jObject.getInt("total_pages");
			
			return new SearchCollectionResult(page, results, totalResults, totalPages);
		} catch (JSONException e) {
			System.out.println("SearchMovieResult");
			return null;
		}
	}
	
	public SearchCollectionResult(int page, Collection[] results, int totalResults, int totalPages){
		this.page = page;
		this.results = results;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
	}
	
	private static Collection[] toCollectionArray(JSONArray jArray){
		Collection[] movies = new Collection[jArray.length()];
		try{
			for(int i =0; i < jArray.length(); i++){
				JSONObject item = jArray.getJSONObject(i);
				Collection movie = Collection.fromJSONString(item.toString());
				
				movies[i] = movie;
			}
			
			return movies;
		}catch(JSONException e){
			System.out.println("SearchCollectionResult -> toCollectionArray()");
			return null;
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	//Page
	public int getPage(){
		return page;
	}
	public void setPage(int page){
		this.page = page;
	}
	
	//Results
	public Collection[] getResults(){
		return results;
	}
	public void setResults(Collection[] results){
		this.results = results;
	}
	
	//TotalResults
	public int getTotalResults(){
		return totalResults;
	}
	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}
	
	//TotalPages
	public int getTotalPages(){
		return totalPages;
	}
	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}
}
