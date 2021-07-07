
/**
 * Write a description of CharacterInPlay here.
 * 
 * @Yiman Liu
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CharacterInPlay {
    private ArrayList<String> myNames;
    private ArrayList<Integer> counts;
    
    public CharacterInPlay (){
        myNames = new ArrayList<String> ();
        counts = new ArrayList<Integer> ();
    }
    
    void update (String person){
        int index = myNames.indexOf(person);
        if (index == -1){
            myNames.add(person);
            counts.add(1);
        }
        else{
            int num = counts.get(index);
            counts.set(index,num+1);
        }
    }
    
    void findAllCharacters (){
        myNames.clear();
        counts.clear();
        FileResource fr = new FileResource ();
        for (String line : fr.lines()){
            int index = line.indexOf(".");
            if (index != -1){
                update(line.substring(0,index));
            }
        }
    }
    
    void characterWithNumParts (int num1,int num2){
        for(int i=0;i<myNames.size();i++){
            if ((counts.get(i) >= num1) && (counts.get(i) <= num2)){
                System.out.println(counts.get(i)+myNames.get(i));
            }
        }
    }
    
    void tester (){
        findAllCharacters();
        characterWithNumParts(10,15);
        //int max = 0;
        //String mainCharacter = null;
        //for (int i =0;i<myNames.size();i++){
            //System.out.println(myNames.get(i)+" "+counts.get(i));
            //if(counts.get(i)>max){
                //max = counts.get(i);
                //mainCharacter = myNames.get(i);
            //}
        //}
        //System.out.println("Main Character is "+mainCharacter+", it appears "+max+" times.");       
    }
    
}














































