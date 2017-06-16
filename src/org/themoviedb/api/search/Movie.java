package org.themoviedb.api.search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
	private String posterPath;
	private boolean adult;
	private String releaseDate;
	private int[] genreIDs;
	private int id;
	private String originalTitle;
	private String originalLanguage;
	private String title;
	private String backdropPath;
	private double popularity;
	private int voteCount;
	private boolean video;
	private float voteAverage;
	
	public Movie(){
		//
	}
	
	public Movie(
			String posterPath, 
			boolean adult, 
			String releaseDate, 
			int[] genreIDs, 
			int id, 
			String originalTitle, 
			String originalLanguage, 
			String title, 
			String backdropPath, 
			double popularity, 
			int voteCount, 
			boolean video, 
			float voteAverage){
		this.posterPath = posterPath;
		this.adult = adult;
		this.releaseDate = releaseDate;
		this.genreIDs = genreIDs;
		this.id = id;
		this.originalTitle = originalTitle;
		this.originalLanguage = originalLanguage;
		this.title = title;
		this.backdropPath = backdropPath;
		this.popularity = popularity;
		this.voteCount = voteCount;
		this.video = video;
		this.voteAverage = voteAverage;
	}
	
	public static Movie fromJSONString(String json){
		try {
			JSONObject jObject = new JSONObject(json);
			String posterPath = jObject.getString("poster_path");
			boolean adult = jObject.getBoolean("adult");
			String releaseDate = jObject.getString("release_date");
			int[] genreIDs = toIntArray(jObject.getJSONArray("genre_ids"));
			int id = jObject.getInt("id");
			String originalTitle = jObject.getString("original_title");
			String originalLanguage = jObject.getString("original_language");
			String title = jObject.getString("title");
			String backdropPath = jObject.getString("backdrop_path");
			double popularity = jObject.getDouble("popularity");
			int voteCount = jObject.getInt("vote_count");
			boolean video = jObject.getBoolean("video");
			float voteAverage = (float)jObject.getDouble("vote_average");
			return new Movie(
					posterPath, 
					adult, 
					releaseDate, 
					genreIDs, 
					id, 
					originalTitle, 
					originalLanguage, 
					title, 
					backdropPath, 
					popularity, 
					voteCount, 
					video, 
					voteAverage);
		} catch (JSONException e) {
			System.out.println("Movie -> fromJSONString()");
			return null;
		}
	}
	
	private static int[] toIntArray(JSONArray jArray){
		int[] intArray = new int[jArray.length()];
		
		try {
			for(int i = 0; i < jArray.length(); i++){
				int item = jArray.getInt(i);
				intArray[i] = item;
			}
		} catch (JSONException e) {
			System.out.println("Movie -> toIntArray()");
		}
		
		return intArray;
	}
	
	//PosterPath
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	//Adult
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	//ReleaseDate
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	//GenreIDs
	public int[] getGenreIDs() {
		return genreIDs;
	}
	public void setGenreIDs(int[] genreIDs) {
		this.genreIDs = genreIDs;
	}
	
	//Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//OriginalTitle
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	
	//OriginalLanguage
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	//Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	//BackdropPath
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	//Popularity
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	//VoteCount
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	//Video
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}

	//VoteAverage
	public float getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
	}
}

/*
  	  "poster_path": "/pTpxQB1N0waaSc3OSn0e9oc8kx9.jpg",
      "adult": false,
      "overview": "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
      "release_date": "1985-07-03",
      "genre_ids": [
        12,
        35,
        878,
        10751
      ],
      "id": 105,
      "original_title": "Back to the Future",
      "original_language": "en",
      "title": "Back to the Future",
      "backdrop_path": "/x4N74cycZvKu5k3KDERJay4ajR3.jpg",
      "popularity": 7.145706,
      "vote_count": 4937,
      "video": false,
      "vote_average": 7.9
 */
