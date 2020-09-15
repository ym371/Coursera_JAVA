
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> frequencies;
    public CharactersInPlay(){
        characters = new ArrayList<String>();
        frequencies = new ArrayList<Integer>();
    }
    public void update(String person){
        if (characters.indexOf(person) == -1){
            characters.add(person);
            frequencies.add(1);
        }
        else{
            int idx = characters.indexOf(person);
            frequencies.set(idx, frequencies.get(idx) + 1);
        }
    }
    public void findAllCharacters(){
        characters.clear();
        frequencies.clear();
        FileResource fr = new FileResource();
        for (String s: fr.lines()){
            int period_pos = s.indexOf('.');
            if (period_pos != -1){
                String name = s.substring(0, period_pos);
                update(name);
            }
        }
    }
    public void tester(){
        findAllCharacters();
        int maxidx = findIndexOfMax();
        frequencies.remove(maxidx);
        characters.remove(maxidx);
        maxidx = findIndexOfMax();
        frequencies.remove(maxidx);
        characters.remove(maxidx);
        maxidx = findIndexOfMax();
        System.out.println(characters.get(maxidx)+ frequencies.get(maxidx));
               
    }
    public void tester2(){
        charactersWithNumParts(10,15);
    }
    public void charactersWithNumParts (int num1, int num2){
        findAllCharacters();
        for (int i = 0; i< characters.size(); i++){
            if ( frequencies.get(i) >= num1 && frequencies.get(i) <= num2){
                System.out.println(characters.get(i) +" " + frequencies.get(i));
            }
        }
    }
    
    public int findIndexOfMax(){
        int maxidx = 0, max = frequencies.get(0);
        for (int i = 1; i < frequencies.size(); i++){
            if (frequencies.get(i) > max){
                max = frequencies.get(i);
                maxidx = i;
            }
        }
        return maxidx;
    }
}
