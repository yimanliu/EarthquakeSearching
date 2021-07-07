
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.FileResource;

public class MovieRunnerSimilarRatings {
    void printAverageRatings() {
        FourthRatings fr = new FourthRatings();
        //System.out.println("rater size: " + tr.getRaterSize());
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings_short.csv"); 
        System.out.println("rater size: " + RaterDatabase.size());        
        ArrayList<Rating> list = fr.getAverageRatings(1);
        Collections.sort(list);
        for (Rating r : list) {
            double average = r.getValue();
            String title = MovieDatabase.getTitle(r.getItem());
            System.out.println(average + " " + title);
        }
    }
   
    void printAverageRatingsByYearAfterAndGenre() {
        FourthRatings fr = new FourthRatings();
        System.out.println("rater size: " + RaterDatabase.size());
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("movie size: " + MovieDatabase.size());
        AllFilters f = new AllFilters();
        YearAfterFilter f1 = new YearAfterFilter(1980);
        f.addFilter(f1);
        GenreFilter f2 = new GenreFilter("Romance");        
        f.addFilter(f2);
        ArrayList<Rating> list = fr.getAverageRatingsByFilter(1, f);
        System.out.println("found movies: " + list.size());
        Collections.sort(list);
        for (Rating r : list) {
            double average = r.getValue();
            String title = MovieDatabase.getTitle(r.getItem());
            String genre = MovieDatabase.getGenres(r.getItem());
            int year = MovieDatabase.getYear(r.getItem());
            System.out.println(average + " " + year + " " + title);
            System.out.println("    " + genre);
        }        
    }    

    void printSimilarRatings() {
        FourthRatings ft = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings.csv"); 
        System.out.println("rater size: " + RaterDatabase.size()); 
        for (Rating rating : ft.getSimilarRatings("71", 20, 5)) {
            String title = MovieDatabase.getTitle(rating.getItem());
            double ratings = rating.getValue();
            System.out.println(title + " " + ratings);
        }
    }     
    
    void printSimilarRatingsByGenre() {
        FourthRatings ft = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings.csv"); 
        System.out.println("rater size: " + RaterDatabase.size()); 
        Filter f = new GenreFilter("Mystery");
        for (Rating rating : ft.getSimilarRatingsByFilter("964", 20, 5, f)) {
            String title = MovieDatabase.getTitle(rating.getItem());
            double ratings = rating.getValue();
            System.out.println(title + " " + ratings);
        }        
    }
    
    void printSimilarRatingsByDirector() {
        FourthRatings ft = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings.csv"); 
        System.out.println("rater size: " + RaterDatabase.size()); 
        Filter f = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        for (Rating rating : ft.getSimilarRatingsByFilter("120", 10, 2, f)) {
            String title = MovieDatabase.getTitle(rating.getItem());
            double ratings = rating.getValue();
            System.out.println(title + " " + ratings);
        }        
    }
    
    void printSimilarRatingsByGenreAndMinutes() {
        FourthRatings ft = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings.csv"); 
        System.out.println("rater size: " + RaterDatabase.size());
        AllFilters f = new AllFilters();
        MinutesFilter f1 = new MinutesFilter(80, 160);
        f.addFilter(f1);
        GenreFilter f2 = new GenreFilter("Drama");        
        f.addFilter(f2);        
        for (Rating rating : ft.getSimilarRatingsByFilter("168", 10, 3, f)) {
            String title = MovieDatabase.getTitle(rating.getItem());
            double ratings = rating.getValue();
            System.out.println(title + " " + ratings);
        }        
    }     
    
    void printSimilarRatingsByYearAfterAndMinutes() {
        FourthRatings ft = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");        
        System.out.println("movie size: " + MovieDatabase.size());
        RaterDatabase.initialize("ratings.csv"); 
        System.out.println("rater size: " + RaterDatabase.size());
        AllFilters f = new AllFilters();
        MinutesFilter f1 = new MinutesFilter(70, 200);
        f.addFilter(f1);
        YearAfterFilter f2 = new YearAfterFilter(1975);        
        f.addFilter(f2);        
        for (Rating rating : ft.getSimilarRatingsByFilter("314", 10, 5, f)) {
            String title = MovieDatabase.getTitle(rating.getItem());
            double ratings = rating.getValue();
            System.out.println(title + " " + ratings);
        }        
    }       
    
}

























