
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setRandom(seed);
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, 25);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, 25);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, 25);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, 25);

    }

    void testHashMap() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        EfficientMarkovModel markov = new EfficientMarkovModel(5);        
        markov.setTraining(st);
        markov.setRandom(531);        
        System.out.println(markov.getRandomText(200));
        markov.printHashMapInfo();
    }
    
    void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 500;
        
        //System.out.println(System.nanoTime());
        //MarkovModel mm = new MarkovModel(2);
        //runModel(mm, st, size, 42);
        //System.out.println(System.nanoTime());
        
        //System.out.println(System.nanoTime());
        EfficientMarkovModel emm = new EfficientMarkovModel(5);
        runModel(emm, st, size, 615);
        //System.out.println(System.nanoTime());
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
