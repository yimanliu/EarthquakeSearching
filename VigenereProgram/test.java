
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class test {
    void testCaesarCipher (){
        FileResource fr = new FileResource ();
        CaesarCipher cc = new CaesarCipher (12);
        String input = fr.asString();
        System.out.println(cc.encrypt(input)); 
    }
    
    void testCaesarCracker (){
        FileResource fr = new FileResource ();
        String encrypted = fr.asString();
        CaesarCracker cc = new CaesarCracker ('a');
        System.out.println(cc.decrypt(encrypted));
    }
    
    void testVigenereCiper (){
        FileResource fr = new FileResource ();
        String input = fr.asString();
        VigenereBreaker vb = new VigenereBreaker ();        
        int[] key = vb.tryKeyLength(input,57,'e');
        VigenereCipher vc = new VigenereCipher (key);
        System.out.println(vc.decrypt(input));
    }
    
    void testSliceString (){
        VigenereBreaker vb = new VigenereBreaker ();
        System.out.println(vb.sliceString("abcdefghijklm",2,3));
    }
    
    void testTryKeyLength (){
        FileResource fr = new FileResource ();
        String encrypted = fr.asString();
        VigenereBreaker vb = new VigenereBreaker ();
        System.out.println(Arrays.toString(vb.tryKeyLength(encrypted,57,'e')));
    }
    
    void testMostCommonCharIn () {
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println("the most common char is "+vb.mostCommonCharIn(vb.readDictionary(fr)));
    }
    
}












































