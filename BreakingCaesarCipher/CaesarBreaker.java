
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class CaesarBreaker {
    
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
    
    public String decrypt (String encrypted){
    CaesarCipher cc = new CaesarCipher();
    int maxIndex = maxIndex(countLetters (encrypted));
    int key = 0;
    if (maxIndex >= 4){
        key = maxIndex - 4;
    }
    else {
        key = 26-(4-maxIndex);
    }
    String message = cc.encrypt(encrypted,26-key);
    return message;
  }
  
  void testDecrypt (){
      System.out.println(decrypt("Gp  bqpok feiq cbbbbbbbbb"));
    }
    
  String halfOfString (String message, int start){
      StringBuilder changeMessage = new StringBuilder (message);
      for (int i=0;i<message.length();i++){
          char ch = changeMessage.charAt(i);
              if ((i+start)%2 == 0){
                  changeMessage.append(ch);
                }
            }
        String newMessage = changeMessage.substring((message.length()));
        return newMessage;
   }
   
 void testHalfOfString (){
       System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    
    int getKey (String s){
        int key  = 0;
        int maxNum = maxIndex(countLetters(s));
        if (maxNum >= 4){
        key = maxNum - 4;
        }
        else {
        key = 26-(4-maxNum);
        }       
        return key;
    }
    
    String decryptTwoKeys (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String s1 = halfOfString(encrypted,0);
        //System.out.println(s1);
        String s2 = halfOfString(encrypted,1);
        //System.out.println(s2);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("key1="+key1+" key2="+key2);
        String decrypted = cc.encryptTwoKeys(encrypted,(26-key1),(26-key2));
        return decrypted;
    }
    
    void testDecryptTwoKeys (){
        FileResource fr = new FileResource ();
        String encrypted = fr.asString();
        System.out.println(decryptTwoKeys(encrypted));
    }
 }










































