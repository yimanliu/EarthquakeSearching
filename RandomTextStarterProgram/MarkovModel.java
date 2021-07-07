
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int num;
    
    public MarkovModel(int n) {
        myRandom = new Random();
        num = n;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - num); 
        String key = myText.substring(index, index + num);
        sb.append(key);
        for(int k=0; k < numChars - num; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        int index = myText.indexOf(key, pos);
        while ((index != -1) && (index < myText.length() - key.length())) {
            String s = myText.substring(index + key.length(), index + key.length() + 1);
            follows.add(s);
            pos = index + 1;
            index = myText.indexOf(key, pos);
        }
        return follows;
    }
    
}
