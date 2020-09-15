
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList; 

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for (String word: fr.words()){
            String word_lower = word.toLowerCase();
            int pos = myWords.indexOf(word_lower);
            if (pos == -1){
                myWords.add(word_lower);
                myFreqs.add(1);
            }
            else{
                myFreqs.set(pos, myFreqs.get(pos) + 1);
            }
        } 
    }
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for (int i = 0; i< myWords.size(); i++){
            //System.out.println(myWords.get(i) + " " + myFreqs.get(i));
        }
        int maxidx = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(maxidx) + " " + myFreqs.get(maxidx));
    }
    public int findIndexOfMax(){
        int maxidx = 0, max = myFreqs.get(0);
        for (int i = 1; i < myFreqs.size(); i++){
            if (myFreqs.get(i) > max){
                max = myFreqs.get(i);
                maxidx = i;
            }
        }
        return maxidx;
    }
            
}
