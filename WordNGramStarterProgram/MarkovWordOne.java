
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            //System.out.println("the key is: " + key);
            ArrayList<String> follows = getFollows(key);
            //System.out.println("the follows is: " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target, int start) {
        int index = 0;
        for (int i = start; i < words.length - 1; i++) {
            if (words[i].equals(target)) {
                index = i + 1;
                return index;
            }
        }
        return -1;
    }
    
    void testIndexOf() {
        String[] text = {"this", "is", "just", "a", "test", "yes", "this", "is", "a", "simple", "test"};
        System.out.println(indexOf(text, "test", 5));
    }
    
    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        for (int i = 0; i < myText.length; i++) {
            if (myText[i].equals(key)) {
                int start = i;
                int pos = indexOf(myText, key, start);
                if (pos != -1) {
                String followWord = myText[pos];
                follows.add(followWord);                
                }
                
                //another way
                
                /*String followWord = myText[i + 1];
                follows.add(followWord);*/
            }
        }
        return follows;
    }

}




























