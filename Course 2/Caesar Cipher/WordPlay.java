
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "aeiou";
        char ch_lower = Character.toLowerCase(ch);
        if (vowels.indexOf(ch_lower) != -1){
            return true;
        }
        return false;
    }
    public void testisVowel(){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder new_phrase = new StringBuilder(phrase);
        for(int k =0; k < new_phrase.length(); k++){
            char currChar = new_phrase.charAt(k);
            if (isVowel(currChar)){
                new_phrase.setCharAt(k, ch);
            }
        }
        return new_phrase.toString();
    }          
    public void testreplaceVowels(){
        System.out.println(replaceVowels("Hellow World", '*'));
    }
    public String emphasize(String phrase, char ch){
        StringBuilder new_phrase = new StringBuilder(phrase);
        char ch_;
        if (Character.isUpperCase(ch)){
            ch_ = Character.toLowerCase(ch);
        }
        else{
            ch_ = Character.toUpperCase(ch);
        }
        for (int k = 0; k<new_phrase.length(); k++){
            char currChar = new_phrase.charAt(k);
            if (currChar == ch || currChar == ch_){
                if (k % 2 ==0){
                    new_phrase.setCharAt(k, '*');
                }
                else{
                    new_phrase.setCharAt(k, '+');
                }
            }
        }
        return new_phrase.toString();
    }
    public void testemphasize(){
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
