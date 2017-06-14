import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.themoviedb.api.*;
import org.themoviedb.api.utils.Region;

public class TheMovieDBMain {
	private static String apiKey = "7b1a60063a92565b24472ec2b2187183";
	
	public static void main(String[] args) {
		TheMovieDB db = new TheMovieDB(apiKey);
		
		SearchMovieParameters parameters = new SearchMovieParameters("back to the future");
		parameters.setYear(1985);
		parameters.setRegion(Region.UNITED_STATES);
		
		SearchMovieResult searchMovieResult = db.searchMovie(parameters);
		
		int totalPages = searchMovieResult.getTotalPages();
		int totalResults = searchMovieResult.getTotalResults();
		
		System.out.println("Total Pages: " + totalPages);
		System.out.println("Total Results: " + totalResults);
		System.out.println("Query String: " + parameters.toString());
		
		ArrayList<Movie> movies = searchMovieResult.getResults();
		System.out.println("Results: ");
		for(int i = 0; i < movies.size(); i++){
			String title = movies.get(i).getTitle();
			System.out.println(String.format("%d. %s", (i +1), title));
		}
	}
	
	private static void readFileTest(){
		try {
			File file = new File("D:\\Users\\kadiryumlu\\Desktop\\params.txt");
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			
			String line = "";
			
			while((line = bReader.readLine()) != null){
				String[] pair = line.split("=");
				
				System.out.println(String.format("%s = %s", pair[0].trim(), pair[1].trim()));
			}
			
			bReader.close();
			fReader.close();
			
		} catch (Exception e) {
			System.out.println("");
		}
	}
}