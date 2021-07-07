
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class TestCaesarCipherTwo {
    
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
  
  public String breakCaesarCipher (String input){
      String input1 = halfOfString(input,0);
      String input2 = halfOfString(input,1); 
      int key1 = getKey(input1);
      int key2 = getKey(input2);
      CaesarCipherTwo cct = new CaesarCipherTwo(key1,key2);
      String decrypted = cct.decrypt(input);
      return decrypted;
  }
  
  void simpleTests(){
      FileResource fr = new FileResource ();
      String input = fr.asString();
      CaesarCipherTwo cct = new CaesarCipherTwo(17,3);
      String encrypted = cct.encrypt(input);
      String decrypted = cct.decrypt(encrypted);
      String autoDecrypted = breakCaesarCipher(encrypted);
      System.out.println(autoDecrypted);
  }
}















































