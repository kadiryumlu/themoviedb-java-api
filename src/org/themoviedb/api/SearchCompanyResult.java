package org.themoviedb.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchCompanyResult {
	private int page;
	private Company[] results;
	private int totalResults;
	private int totalPages;
	
	public SearchCompanyResult(){
		
	}
	
	public static SearchCompanyResult fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			int page = jObject.getInt("page");
			Company[] results = toCompanyArray(jObject.getJSONArray("results"));
			int totalResults = jObject.getInt("total_results");
			int totalPages = jObject.getInt("total_pages");
			
			return new SearchCompanyResult(page, results, totalResults, totalPages);
		} catch (JSONException e) {
			System.out.println("SearchCompanyResult");
			return null;
		}
	}
	
	public SearchCompanyResult(int page, Company[] results, int totalResults, int totalPages){
		this.page = page;
		this.results = results;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
	}
	
	private static Company[] toCompanyArray(JSONArray jArray){
		Company[] companies = new Company[jArray.length()];
		try{
			for(int i =0; i < jArray.length(); i++){
				JSONObject item = jArray.getJSONObject(i);
				Company company = Company.fromJSONString(item.toString());
				
				companies[i] = company;
			}
			
			return companies;
		}catch(JSONException e){
			System.out.println("SearchCompanyResult -> toCompanyArray()");
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
	public Company[] getResults(){
		return results;
	}
	public void setResults(Company[] results){
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
