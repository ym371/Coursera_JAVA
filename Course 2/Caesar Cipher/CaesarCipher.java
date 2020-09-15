
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String new_upper = upper.substring(key) + upper.substring(0, key);
        String lower = upper.toLowerCase(), new_lower = new_upper.toLowerCase();
        
        for (int i = 0; i< encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int index_upper = upper.indexOf(currChar);
            int index_lower = lower.indexOf(currChar);
            if (index_upper != -1){
                char new_char = new_upper.charAt(index_upper);
                encrypted.setCharAt(i, new_char);
            }
            else if (index_lower != -1){
                char new_char = new_lower.charAt(index_lower);
                encrypted.setCharAt(i, new_char);
            }
        }
        return encrypted.toString();
    }
    public void testencrypt(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }   
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String new_upper_key1 = upper.substring(key1) + upper.substring(0, key1);
        String new_upper_key2 = upper.substring(key2) + upper.substring(0, key2);
        String lower = upper.toLowerCase(), new_lower_key1 = new_upper_key1.toLowerCase(), 
            new_lower_key2 = new_upper_key2.toLowerCase();
        
        for (int i = 0; i< encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int index_upper = upper.indexOf(currChar);
            int index_lower = lower.indexOf(currChar);
            if (i % 2 ==0){
                if (index_upper != -1){
                    char new_char = new_upper_key1.charAt(index_upper);
                    encrypted.setCharAt(i, new_char);
                }
                else if (index_lower != -1){
                    char new_char = new_lower_key1.charAt(index_lower);
                    encrypted.setCharAt(i, new_char);
                }
            }
            else{
                if (index_upper != -1){
                    char new_char = new_upper_key2.charAt(index_upper);
                    encrypted.setCharAt(i, new_char);
                }
                else if (index_lower != -1){
                    char new_char = new_lower_key2.charAt(index_lower);
                    encrypted.setCharAt(i, new_char);
                }
            }
        }
        return encrypted.toString();
    }
    public void testencryptTwoKeys(){
        System.out.println(encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 26-14, 2));
    }
}
