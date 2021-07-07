
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class Tester {
    void testGetFollowsWithFile() {
        MarkovOne markov = new MarkovOne();
        FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	markov.setTraining(st);  
	System.out.println(markov.getFollows("he").size());
    }
}
