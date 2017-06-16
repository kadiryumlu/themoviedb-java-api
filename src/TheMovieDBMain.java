import org.themoviedb.api.*;
import org.themoviedb.api.search.*;
import org.themoviedb.api.utils.*;

public class TheMovieDBMain {
	private static final String API_KEY = "7b1a60063a92565b24472ec2b2187183";
	private static TheMovieDB tmdb;
	
	public static void main(String[] args) {
		tmdb = new TheMovieDB(API_KEY);
		searchKeywordExample();
	}
	
	public static void searchCollectionExample(){
		SearchCollectionParameters parameters = new SearchCollectionParameters("matrix");
		parameters.setLanguage(Language.English);
		parameters.setPage(1);
		
		try{
			SearchCollectionResult searchCollectionResult = tmdb.searhCollection(parameters);
			
			int totalPages = searchCollectionResult.getTotalPages();
			int totalResults = searchCollectionResult.getTotalResults();
			
			System.out.println("Total Pages: " + totalPages);
			System.out.println("Total Results: " + totalResults);
			System.out.println("Query String: " + parameters.toString());
			
			Collection[] collections = searchCollectionResult.getResults();
			System.out.println("Results: ");
			for(int i = 0; i < collections.length; i++){
				int id = collections[i].getId();
				String backdropPath = collections[i].getBackdropPath();
				String name = collections[i].getName();
				String posterPath = collections[i].getPosterPath();
				
				System.out.println(String.format("id: %d\t\tbackdrop_path: %s\t\tname: %s\t\tposter_path: %s", id, backdropPath, name, posterPath));
			}
			
		} catch(HttpResponseException e){
			ErrorResult error = e.getErrorResult();
			System.out.println("Error Status Code: " + error.getStatusCode());
			System.out.println("Error Status Message: \r\n" + error.getStatusMessage());
		}
	}
	
	public static void searchCompanyExample(){
		SearchCompanyParameters parameters = new SearchCompanyParameters("universal");
		parameters.setPage(2);
		
		try{
			SearchCompanyResult searchCompanyResult = tmdb.searhCompany(parameters);
			
			int totalPages = searchCompanyResult.getTotalPages();
			int totalResults = searchCompanyResult.getTotalResults();
			
			System.out.println("Total Pages: " + totalPages);
			System.out.println("Total Results: " + totalResults);
			System.out.println("Query String: " + parameters.toString());
			
			Company[] companies = searchCompanyResult.getResults();
			System.out.println("Results: ");
			for(int i = 0; i < companies.length; i++){
				int id = companies[i].getId();
				String name = companies[i].getName();
				String logoPath = companies[i].getLogoPath();
				
				System.out.println(String.format("id: %d\t\tname: %s\t\t logo_path: %s", id, name, logoPath));
			}
			
		} catch(HttpResponseException e){
			ErrorResult error = e.getErrorResult();
			System.out.println("Error Status Code: " + error.getStatusCode());
			System.out.println("Error Status Message: \r\n" + error.getStatusMessage());
		}
	}
	
	public static void searchKeywordExample(){
		SearchKeywordParameters parameters = new SearchKeywordParameters("movie");
		
		try{
			SearchKeywordResult searchKeywordResult = tmdb.searhKeyword(parameters);
			
			int totalPages = searchKeywordResult.getTotalPages();
			int totalResults = searchKeywordResult.getTotalResults();
			
			System.out.println("Total Pages: " + totalPages);
			System.out.println("Total Results: " + totalResults);
			System.out.println("Query String: " + parameters.toString());
			
			Keyword[] keywords = searchKeywordResult.getResults();
			System.out.println("Results: ");
			for(int i = 0; i < keywords.length; i++){
				int id = keywords[i].getId();
				String name = keywords[i].getName();
				
				System.out.println(String.format("id: %d\t\tname: %s", id, name));
			}
			
		} catch(HttpResponseException e){
			ErrorResult error = e.getErrorResult();
			System.out.println("Error Status Code: " + error.getStatusCode());
			System.out.println("Error Status Message: \r\n" + error.getStatusMessage());
		}
	}
	
	public static void searchMovieExample(){
		SearchMovieParameters parameters = new SearchMovieParameters("back to the future");
		parameters.setYear(1985);
		parameters.setRegion(Region.UNITED_STATES);
		
		try{
			SearchMovieResult searchMovieResult = tmdb.searchMovie(parameters);
			
			int totalPages = searchMovieResult.getTotalPages();
			int totalResults = searchMovieResult.getTotalResults();
			
			System.out.println("Total Pages: " + totalPages);
			System.out.println("Total Results: " + totalResults);
			System.out.println("Query String: " + parameters.toString());
			
			Movie[] movies = searchMovieResult.getResults();
			System.out.println("Results: ");
			for(int i = 0; i < movies.length; i++){
				String title = movies[i].getTitle();
				System.out.println(String.format("%d. %s", (i +1), title));
			}
		} catch(HttpResponseException e){
			ErrorResult error = e.getErrorResult();
			System.out.println("Error Status Code: " + error.getStatusCode());
			System.out.println("Error Status Message: \r\n" + error.getStatusMessage());
		}
	}
}