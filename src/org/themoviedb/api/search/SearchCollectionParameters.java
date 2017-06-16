package org.themoviedb.api.search;

import java.net.URLEncoder;
import org.themoviedb.api.utils.Language;

public class SearchCollectionParameters {
	private Language language;
	private String query;
	private int page;
	
	public SearchCollectionParameters(String query){
		this.language = null;
		this.query = query;
		this.page = 0;
	}
	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		StringBuffer parameters = new StringBuffer();
		
		try{
			parameters.append("&query=" + URLEncoder.encode(query, "UTF-8"));
			
			if(language != null){
				parameters.append("&language=" + language);
			}
			if(page > 0){
				parameters.append("&page=" + page);
			}
		} catch(Exception e){
			System.out.println("SearchCompanyParameters -> toString()\n" + e.getMessage());
		}
		
		return parameters.toString();
	}
}
