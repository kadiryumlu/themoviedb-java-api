package org.themoviedb.api.search;

import java.net.URLEncoder;
import org.themoviedb.api.utils.Region;
import org.themoviedb.api.utils.Language;

public class SearchMovieParameters {
	private Language language;
	private String query;
	private int page;
	private boolean includeAdult;
	private Region region;
	private int year;
	private int primaryReleaseYear;
	
	public SearchMovieParameters(String query){
		this.language = null;
		this.query = query;
		this.page = 0;
		this.includeAdult = false;
		this.region = null;
		this.year = 0;
		this.primaryReleaseYear = 0;
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

	public boolean isIncludeAdult() {
		return includeAdult;
	}
	public void setIncludeAdult(boolean includeAdult) {
		this.includeAdult = includeAdult;
	}

	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public int getPrimaryReleaseYear() {
		return primaryReleaseYear;
	}
	public void setPrimaryReleaseYear(int primaryReleaseYear) {
		this.primaryReleaseYear = primaryReleaseYear;
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
			if(includeAdult != false){
				parameters.append("&include_adult=" + includeAdult);
			}
			if(region != null){
				parameters.append("&region=" + region);
			}
			if(year > 0){
				parameters.append("&year=" + year);
			}
			if(primaryReleaseYear > 0){
				parameters.append("&primary_release_year=" + primaryReleaseYear);
			}
		} catch(Exception e){
			System.out.println("SearchMovieParameters -> toString()\n" + e.getMessage());
		}
		
		return parameters.toString();
	}
}