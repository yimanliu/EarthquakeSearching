
/**
 * Write a description of wordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class wordPlay {
    boolean isVowel (char ch){
        char lowerCh = Character.toLowerCase(ch);
        if ((lowerCh == 'a')||(lowerCh == 'e')||(lowerCh == 'i')||
            (lowerCh == 'o')||(lowerCh == 'u')){
            return true;
            }
        return false;
    }
    
    String replaceVowels(String phrase, char ch){
        StringBuilder changePhrase = new StringBuilder(phrase);
        for (int i=0;i<phrase.length();i++){
            char newCh = changePhrase.charAt(i);
            if (isVowel(newCh)){
                changePhrase.setCharAt(i,ch);
            }
        }
        String phraseGot = changePhrase.toString();
        return phraseGot;
    }
    
    String emphasize (String phrase, char ch){
        StringBuilder changePhrase = new StringBuilder (phrase);
        for (int i=0;i<phrase.length();i++){
            char newCh = Character.toLowerCase(changePhrase.charAt(i));
            if (newCh == ch){
                if ((i%2 == 0)){
                    changePhrase.setCharAt(i,'*');
                }
                if (i%2 != 0){
                    changePhrase.setCharAt(i,'+');
                }
            }
        }
        String phraseGot = changePhrase.toString();
        return phraseGot;
    }
    
    void test (){
        //System.out.println(isVowel('a'));
        //System.out.println(replaceVowels("Hello World",'*'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}































