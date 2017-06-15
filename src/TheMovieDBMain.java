import org.themoviedb.api.*;
import org.themoviedb.api.utils.ErrorResult;
import org.themoviedb.api.utils.HttpResponseException;
import org.themoviedb.api.utils.Region;

public class TheMovieDBMain {
	private static String apiKey = "7b1a60063a92565b24472ec2b2187183";
	private static TheMovieDB tmdb;
	
	public static void main(String[] args) {
		tmdb = new TheMovieDB(apiKey);
		searchCompanyExample();
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
}