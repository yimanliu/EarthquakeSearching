
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class RecommendationRunner implements Recommender {
    private Random myRandom;
    private int randomNum;
    private int numSimilarRaters;
    private int minimalRaters;
    private int maxRecNum;
    
    public RecommendationRunner(){
        myRandom = new Random();
        randomNum = 8;
        numSimilarRaters = 10;
        minimalRaters = 2;
        maxRecNum = 15;
    }
    
    public ArrayList<String> getItemsToRate(){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ArrayList<String> movieList = new ArrayList<String>();
        Filter f = new TrueFilter();
        ArrayList<String> myMovies = MovieDatabase.filterBy(f);
        for (int k=0; k < randomNum; k++){
            int currIdx = myRandom.nextInt(MovieDatabase.size());;
            String currMovieID = myMovies.get(currIdx);
            movieList.add(currMovieID);
        }
        return movieList;
    }
    
    public void printRecommendationsFor (String webRaterID){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings fr = new FourthRatings();
        ArrayList<Rating> ret = fr.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters);
        int num = ret.size();
        if (num == 0){
            System.out.println("Ooops, Recommendation Not Found");
        } else {
            if (num > maxRecNum){
                num = maxRecNum;
            }
            String header = ("<table> <tr> <th>Movie</th> <th>Ratings</th> </tr>");
            String body = "";
            for (int k=0; k<num; k++){
                Rating currRating = ret.get(k);
                String currMovieID = currRating.getItem();
                String currMovieTitle = MovieDatabase.getTitle(currMovieID);
                double currRatingValue = currRating.getValue();
                String currGenre = MovieDatabase.getGenres(currMovieID);
                body += printOut(currMovieTitle, currRatingValue, currGenre);
            }
            System.out.println(header + body + "</table>");
        }
    }
    
    private String printOut(String header, double value, String genre){
        return ("<tr> <td>" + header + "</td> <td>" + Double.toString(value) + "</td> </tr>");
    }
}