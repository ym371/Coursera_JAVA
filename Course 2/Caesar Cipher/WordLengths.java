
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public void countWordLengths (FileResource resource, int[] counts){
        for (String word: resource.words()){
            int length = word.length();
            if (!Character.isLetter(word.charAt(0))){
                length -= 1;
            }
            if (length >0 && !Character.isLetter(word.charAt(length-1))){
                length -= 1;
            }
            if (length >= 0){counts[length] += 1;}
        }
    }
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        for (int i = 0; i<31; i++){
            System.out.println(i + ":" + counts[i]);
        }
        System.out.println(indexOfMax(counts));
    }
    public int indexOfMax(int[] values){
        int max = values[0], max_idx = 0;
        for (int i = 1; i<values.length; i++){
            if (values[i] > max){
                max = values[i];
                max_idx = i;
            }
        }
        return max_idx;
    }
}
