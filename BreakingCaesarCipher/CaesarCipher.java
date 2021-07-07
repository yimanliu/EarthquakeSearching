
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class CaesarCipher {
    String encrypt (String input, int key){
        StringBuilder changeInput = new StringBuilder (input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlphabetUpper = alphabet.substring(key)+alphabet.substring(0,key);
        String newAlphabetLower = newAlphabetUpper.toLowerCase();
        StringBuilder changeNewAlphabetUpper = new StringBuilder (newAlphabetUpper);
        StringBuilder changeNewAlphabetLower = new StringBuilder (newAlphabetLower);        
        for (int i=0;i<input.length();i++){
            char ch = changeInput.charAt(i);
            char upperCh = Character.toUpperCase(ch);
            if (Character.isLetter(ch)){
            int index = alphabet.indexOf(upperCh);
                if(Character.isUpperCase(ch)){
                   changeInput.setCharAt(i,changeNewAlphabetUpper.charAt(index));                 
                } 
                if(Character.isLowerCase(ch)){
                   changeInput.setCharAt(i,changeNewAlphabetLower.charAt(index));                 
                }                     
            }
        }
        String inputGot = changeInput.toString();        
        return inputGot;
    }
    
    String encryptTwoKeys (String input, int key1, int key2){
        StringBuilder changeInput = new StringBuilder (input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlphabetUpper1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String newAlphabetLower1 = newAlphabetUpper1.toLowerCase();
        StringBuilder changeNewAlphabetUpper1 = new StringBuilder (newAlphabetUpper1);
        StringBuilder changeNewAlphabetLower1 = new StringBuilder (newAlphabetLower1);
        String newAlphabetUpper2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        String newAlphabetLower2 = newAlphabetUpper2.toLowerCase();
        StringBuilder changeNewAlphabetUpper2 = new StringBuilder (newAlphabetUpper2);
        StringBuilder changeNewAlphabetLower2 = new StringBuilder (newAlphabetLower2);   
        for (int i=0;i<input.length();i++){
            int k = 0;
            char ch = changeInput.charAt(i);
            char upperCh = Character.toUpperCase(ch);
            if (Character.isLetter(ch)){
            int index = alphabet.indexOf(upperCh);
                if (i%2 != 0){
                    if(Character.isUpperCase(ch)){
                       changeInput.setCharAt(i,changeNewAlphabetUpper2.charAt(index));                 
                    } 
                    if(Character.isLowerCase(ch)){
                       changeInput.setCharAt(i,changeNewAlphabetLower2.charAt(index));                 
                    }                  
                }
                if (i%2 == 0){
                    if(Character.isUpperCase(ch)){
                       changeInput.setCharAt(i,changeNewAlphabetUpper1.charAt(index));                 
                    } 
                    if(Character.isLowerCase(ch)){
                       changeInput.setCharAt(i,changeNewAlphabetLower1.charAt(index));                 
                    }                     
                }
            }
        }
        String inputGot = changeInput.toString();        
        return inputGot;        
    }
    
    void test(){
        //FileResource fr = new FileResource ();
        //String input = fr.asString();
        System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",24,6));
    }
}









































