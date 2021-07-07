
/**
 * Write a description of CaesarCipher here.
 * 
 * @Yiman Liu
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher (int key){
        mainKey = key;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(mainKey) + alphabet.substring(0,mainKey);
    }
    
    public String encrypt (String input){
        StringBuilder encrypted = new StringBuilder (input);
        for (int i=0;i<input.length();i++){
            char ch = encrypted.charAt(i);
            if (Character.isLetter(ch)){                
                if (Character.isUpperCase(ch)){
                char lowerCh = Character.toLowerCase(ch);
                int index = alphabet.indexOf(lowerCh);
                encrypted.setCharAt(i,Character.toUpperCase(shiftedAlphabet.charAt(index)));                 
                }
                else {
                int index = alphabet.indexOf(ch); 
                encrypted.setCharAt(i,shiftedAlphabet.charAt(index));                 
                }           
            }
        }
        String encryptedInput = encrypted.toString();
        return encryptedInput;
    }
    
    String decrypt (String input){
        //when create this object "cc", you give the "key" value = (26-mainKey)
        //when you creater other object outside this class, the key you give is
        //the real value of key. 
        CaesarCipher cc = new CaesarCipher (26-mainKey);
        //this input should be the encrypted string
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
    
    void test (){
        FileResource fr = new FileResource ();
        String input = fr.asString();
        System.out.println(encrypt(input));
    }
}





























