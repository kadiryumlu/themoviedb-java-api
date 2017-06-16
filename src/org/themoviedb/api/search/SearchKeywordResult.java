package org.themoviedb.api.search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchKeywordResult {
	private int page;
	private Keyword[] results;
	private int totalResults;
	private int totalPages;
	
	public SearchKeywordResult(){
		
	}
	
	public static SearchKeywordResult fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int page = jObject.getInt("page");
			Keyword[] results = toKeywordArray(jObject.getJSONArray("results"));
			int totalResults = jObject.getInt("total_results");
			int totalPages = jObject.getInt("total_pages");
			
			return new SearchKeywordResult(page, results, totalResults, totalPages);
		} catch (JSONException e) {
			System.out.println("SearchKeywordResult");
			return null;
		}
	}
	
	public SearchKeywordResult(int page, Keyword[] results, int totalResults, int totalPages){
		this.page = page;
		this.results = results;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
	}
	
	private static Keyword[] toKeywordArray(JSONArray jArray){
		Keyword[] keywords = new Keyword[jArray.length()];
		try{
			for(int i =0; i < jArray.length(); i++){
				JSONObject item = jArray.getJSONObject(i);
				Keyword keyword = Keyword.fromJSONString(item.toString());
				
				keywords[i] = keyword;
			}
			
			return keywords;
		}catch(JSONException e){
			System.out.println("SearchKeywordResult -> toCompanyArray()");
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
	public Keyword[] getResults(){
		return results;
	}
	public void setResults(Keyword[] results){
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
