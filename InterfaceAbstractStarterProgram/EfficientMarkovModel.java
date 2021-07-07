
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel{

    private int num;
    private HashMap<String, ArrayList<String>> map;
    
    public EfficientMarkovModel(int n) {
        num = n;
        map = new HashMap<String, ArrayList<String>>();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
        printHashMapInfo();
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
    
    private void buildMap() {
        for (int i = 0; i <= myText.length() - num; i++) {
            String key = myText.substring(i, i + num);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<String>();
                map.put(key, list);
            } 
            if (i < myText.length() - num) {
                String follow = myText.substring(i + num, i + num + 1);
                map.get(key).add(follow);         
            }        
        }
    }
    
    void printHashMapInfo() {
        int max = 0;
        String largestKey = " ";
        for (String s : map.keySet()) {
            if (map.get(s).size() > max) {
                max = map.get(s).size();
            }
        }
        System.out.println("the size of the largest value is: " + max);
        System.out.println("the size of key is " + map.size());
        /*System.out.println("the keys that have the maximum size value is: ");        
        for (String s : map.keySet()) {
            if (map.get(s).size() == max) {
                System.out.println(s);
            }
        }*/        
    }
    
    public ArrayList<String> getFollows(String key) {        
        return map.get(key);
    }
    
    public String toString() {
       return "this is the EfficientMarkovModel class of " + num;
    }    
    
}





























