
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.Random;

public class WordLengths {
    int[] countWordLengths (FileResource resource, int[] counts){
        int i = 0;
        for (String word : resource.words()){
            StringBuilder changeWord = new StringBuilder(word);
            char startCh = changeWord.charAt(0);
            char endCh = changeWord.charAt(word.length()-1);
            int length = 0;
            if(Character.isLetter(startCh)){
                if(Character.isLetter(endCh)){
                    length = word.length()+1;
                }
                else {
                    length = word.length();
                }
            }
            if (Character.isLetter(endCh)){
                 length = word.length();
            }
            else {
                 length = word.length()-1;
            }
            
            for (i=0;i<counts.length;i++){
                if (length == i){
                    counts[i]++;
                }
                if (length >= (counts.length)){
                    counts[counts.length-1]++;
                }
            }       
         }
        for (i=0;i<counts.length;i++){
            System.out.println("Length of "+i+"\t"+" has "+counts[i]+"\t"+" times.");             
        }
        return counts;
     }
    
    int indexOfMax (int[] values){
        int maxValue = 0;
        for (int i=0; i<values.length; i++){
            if(values[i] > maxValue){
               maxValue = values[i];
            }
        }
        return maxValue;
    } 
     
    void testCountWordLengths(){
         FileResource resource = new FileResource();
         int[] counts = new int[20];
         System.out.println(indexOfMax(countWordLengths(resource,counts)));
    }
        
}








































