
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
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
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index + 1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            //System.out.println("the key is: " + key1 + key2);
            ArrayList<String> follows = getFollows(key1, key2);
            //System.out.println("the follows is: " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target1, String target2, int start) {
        int index = 0;
        for (int i = start; i < words.length - 2; i++) {
            if ((words[i].equals(target1)) && (words[i + 1].equals(target2))) {
                index = i + 2;
                return index;
            }
        }
        return -1;
    }
    
    void testIndexOf() {
        String[] text = {"this", "is", "just", "a", "test", "yes", "this", "is", "a", "simple", "test"};
        System.out.println(indexOf(text, "this", "is", 0));
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        for (int i = 0; i < myText.length - 1; i++) {
            if ((myText[i].equals(key1)) && (myText[i + 1].equals(key2))) {
                int start = i;
                int pos = indexOf(myText, key1, key2, start);
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




























