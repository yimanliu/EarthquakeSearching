

import java.io.*; 
import java.util.List; 
import java.util.ArrayList; 

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
        myHash = 0;
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method
        for (int i = 0; i < myWords.length; i++) {
            ret += myWords[i] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < other.length(); i++) {
            if (!this.wordAt(i).equals(other.wordAt(i))) {
                return false;
            }
        }
        return true;

    }

       public WordGram shiftAdd(String word) { 
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method 
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0; i < myWords.length; i++) {
            newList.add(myWords[i]);
        }
        newList.add(word);
        String[] newWords = new String[newList.size()];
        newWords = newList.toArray(newWords);
        WordGram out = new WordGram(newWords, 1, myWords.length);
        return out;
    }
    
    public int hashCode() {
        if (myHash == 0) {
            myHash = this.toString().hashCode();
        }
        return myHash;
    }
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    