
/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, ArrayList<String>> myMap;
    
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
        myMap = new HashMap<WordGram, ArrayList<String>>();
   }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
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
        follows = myMap.get(kGram);
        return follows;
        }
        
    private HashMap<WordGram, ArrayList<String>> buildMap() {
        for (int i = 0; i <= myText.length - myOrder; i++) {
            WordGram wg = new WordGram(myText, i, myOrder);
            if (i == myText.length - myOrder) {
                myMap.put(wg, new ArrayList<String>());
            } 
            if (i < myText.length - myOrder) {
                if (!myMap.containsKey(wg)) {
                    ArrayList<String> list = new ArrayList();
                    myMap.put(wg, list);
                    list.add(myText[i + myOrder]);
                } else {
                    myMap.get(wg).add(myText[i + myOrder]);
                }            
            }
        }
        return myMap;
    }
   
    void printHashMapInfo() {
        System.out.println(myMap);
        System.out.println("the number of keys is: " + myMap.size());
        int max = 0;
        WordGram kGram = null;
        for (WordGram wg : myMap.keySet()) {
            if (myMap.get(wg).size() > max) {
                max = myMap.get(wg).size();
                kGram = wg;
            }
        }
        System.out.println("the size of the largest value is: " + max);
        System.out.println("the maximum size value of key is: " + kGram);
    }
    
}



























