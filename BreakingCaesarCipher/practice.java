
/**
 * Write a description of practice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.Random;

public class practice {
    //Number the first 20th common  words
    public String[] getCommon(){
        FileResource fr = new FileResource ("common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String s : fr.words()){
            common[index] = s;
            index++;
        }
        return common;
    }
    
    public int indexOf(String[] list, String word){
        for (int i=0; i<list.length; i++){
            if(list[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
    //Count the number of common words occurrences in file "fr"
    public void countWords (FileResource fr, String[] common, int[] counts){
        for (String word : fr.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index != -1){
                counts[index]++;
            }
        }
    }
    
    void countShakespeare(){
        String[] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for (int i=0;i<plays.length;i++){
            FileResource fr = new FileResource(plays[i]);
            countWords(fr, common, counts);
            System.out.println("done with "+plays[i]);
        }
        
        for (int i=0;i<common.length;i++){
            System.out.println(common[i]+"\t"+counts[i]);
        }
        
    }
    
    public void simulate(int rolls){
        Random rand = new Random();
        int[] counts = new int[13];
        for (int i=0;i<rolls;i++){
            int d1 = rand.nextInt(6)+1;
            int d2 = rand.nextInt(6)+1;
            counts[d1+d2]++;
        }
        
        for(int i=2; i<counts.length;i++){
        System.out.println(i+"'s"+counts[i]+"\t"+100.0*counts[i]/rolls);
        }
    }
}




































