/**
 * Write a description of CaesarCipher here.
 * 
 * @Yiman Liu
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class TestCaesarCipher {
    
    int[] countLetters (String encrypted){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder changeEncrypted = new StringBuilder (encrypted);
        int[] counts = new int[26];
        for (int i=0;i<encrypted.length();i++){
            char ch = Character.toLowerCase(changeEncrypted.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1){
                counts[index]++;
            }
        }
        return counts;
    }
    
    int maxIndex (int[] counts){
        int maxCounts = 0;
        int maxIndex = 0;
        for (int i=0;i<counts.length;i++){
            if(counts[i] > maxCounts){
                maxCounts = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }    
    
    public String breakCaesarCipher (String input){
        int max = maxIndex(countLetters (input));
        int key = 0;
        if (max >= 4){
            key = max - 4;
        }
        else {
            key = 26-(4-max);
        }
        CaesarCipher cc = new CaesarCipher (key);
        String decrypted = cc.decrypt(input);
        return decrypted;
    }  
    
    void simpleTests (){
        FileResource fr = new FileResource ();
        String contents = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(contents);
        String decrypted = cc.decrypt(encrypted);
        String autoDecrypted = breakCaesarCipher(encrypted);
        //System.out.println(encrypted);
        //System.out.println(decrypted);
        
    }
    
}
























































