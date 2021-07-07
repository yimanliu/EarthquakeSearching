
/**
 * Write a description of WordFrequencies here.
 * 
 * @Yiman Liu
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies (){
        myWords = new ArrayList<String> ();
        myFreqs = new ArrayList<Integer> ();
    }
    
    void findUnique (){

        FileResource fr = new FileResource();
        for (String word : fr.words()){
            word=word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int num = myFreqs.get(index);
                myFreqs.set(index,num+1);
            }
        }
    }
    
    int findIndexOfMax (){
        int max = 0;
        int index = 0;
        for (int i=0;i<myWords.size();i++){
            if (myFreqs.get(i) > max){
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }
    
    void tester (){
        findUnique ();
        System.out.println("the number of unique words is "+myWords.size());
        for (int i=0;i<30;i++){
            System.out.println(myFreqs.get(i)+" "+myWords.get(i));
        }
        int maxIndex = findIndexOfMax();
       System.out.println(myWords.get(maxIndex)+" "+myFreqs.get(maxIndex));
    }
    
}























































