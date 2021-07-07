
/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
   }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram wg = new WordGram(myText, index, myOrder);
        //System.out.println("test wg: " + wg);
        sb.append(wg.toString()).append(" ");
        for(int k=0; k < numWords - myOrder; k++){
            //System.out.println("the key is: " + key);
            ArrayList<String> follows = getFollows(wg);
            //System.out.println("the follows is: " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            wg = wg.shiftAdd(next);
            //System.out.println("yiman liu test new wg " + wg); 
        }
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, WordGram target, int start) {
        int index = 0;
        int size = target.length();
        for (int k = start; k < words.length - size; k++) {
            WordGram wg = new WordGram(words, k, size);
            if (wg.equals(target)) {
                index = k + size;
                //System.out.println("yimanliu test indexOf method" + index);
                return index;
            }
        }
        return -1;
    }
    
    void testIndexOf() {
        String[] text = {"this", "is", "just", "a", "test", "yes", "this", "is", "a", "simple", "test"};
        WordGram wg = new WordGram(text, 0, 2);
        //System.out.println(indexOf(text, wg, 3));
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < myText.length - myOrder; i++) {
                int pos = indexOf(myText, kGram, start);
                if (pos == -1) {
                    break;
                }
                String followWord = myText[pos];
                follows.add(followWord);
                start = pos + 1;
            }           
        return follows;
        }
    }



























