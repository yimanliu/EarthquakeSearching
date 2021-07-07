
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo (int key1, int key2){
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
    }
    
    public String encrypt (String input){
        StringBuilder changeInput = new StringBuilder (input);
        for (int i=0;i<input.length();i++){
            char ch = changeInput.charAt(i);
            if (Character.isLetter(ch)){            
                if (i%2 == 0){
                    if(Character.isUpperCase(ch)){
                        char lowerCh = Character.toLowerCase(ch);
                        int index = alphabet.charAt(lowerCh);
                        changeInput.setCharAt(i,Character.toUpperCase(shiftedAlphabet1.charAt(index)));                 
                    } 
                    if(Character.isLowerCase(ch)){
                        int index = alphabet.charAt(ch);
                        changeInput.setCharAt(i,shiftedAlphabet1.charAt(index));               
                    }                  
                }
                if (i%2 != 0){
                    if(Character.isUpperCase(ch)){
                        char lowerCh = Character.toLowerCase(ch);
                        int index = alphabet.charAt(lowerCh);
                        changeInput.setCharAt(i,Character.toUpperCase(shiftedAlphabet2.charAt(index)));                 
                    } 
                    if(Character.isLowerCase(ch)){
                        int index = alphabet.charAt(ch);
                        changeInput.setCharAt(i,shiftedAlphabet2.charAt(index));               
                    }                  
                }                
            }        
        }
        String encrypted = changeInput.toString();        
        return encrypted; 
    }
    
    public String decrypt (String input){
        CaesarCipherTwo cct = new CaesarCipherTwo (26-mainKey1,26-mainKey2);
        String decrypted = cct.encrypt(input);
        return decrypted;
    }
}



































