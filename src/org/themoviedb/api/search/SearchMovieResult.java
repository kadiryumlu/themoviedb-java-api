package org.themoviedb.api.search;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchMovieResult {
	private int page;
	private Movie[] results;
	private int totalResults;
	private int totalPages;
	
	public SearchMovieResult(){
		
	}
	
	public static SearchMovieResult fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int page = jObject.getInt("page");
			Movie[] results = toMovieArray(jObject.getJSONArray("results"));
			int totalResults = jObject.getInt("total_results");
			int totalPages = jObject.getInt("total_pages");
			
			return new SearchMovieResult(page, results, totalResults, totalPages);
		} catch (JSONException e) {
			System.out.println("SearchMovieResult");
			return null;
		}
	}
	
	public SearchMovieResult(int page, Movie[] results, int totalResults, int totalPages){
		this.page = page;
		this.results = results;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
	}
	
	private static Movie[] toMovieArray(JSONArray jArray){
		Movie[] movies = new Movie[jArray.length()];
		try{
			for(int i =0; i < jArray.length(); i++){
				JSONObject item = jArray.getJSONObject(i);
				Movie movie = Movie.fromJSONString(item.toString());
				
				movies[i] = movie;
			}
			
			return movies;
		}catch(JSONException e){
			System.out.println("SearchMovieResult -> toMovieArray()");
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
	public Movie[] getResults(){
		return results;
	}
	public void setResults(Movie[] results){
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
