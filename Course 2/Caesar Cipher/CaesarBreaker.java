
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    public int[] countLetters(String s){
        int []counts = new int[26];
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            int idx = alpha.indexOf(ch);
            if (idx != -1){
                counts[idx] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int[] values){
        int max = values[0], max_idx = 0;
        for (int i = 1; i<values.length; i++){
            if (values[i] > max){
                max = values[i];
                max_idx = i;
            }
        }
        return max_idx;
    }
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freq = countLetters(encrypted);
        int maxidx = maxIndex(freq);
        int dkey = maxidx - 4;
        if (dkey < 0){
            dkey = dkey + 26;
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    public void testDecrypt(){
        System.out.println(decrypt("Ixbo. Jv kbzbppxofbp xob bjyxoh'a."));
    }
    public String halfOfString (String message, int start){
        StringBuilder s = new StringBuilder();
        for (int i = start; i< message.length(); i+= 2){
            s.append(message.charAt(i));
        }
        return s.toString();
    }
    public void testhalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    public int getKey(String s){
        int[] freq = countLetters(s);
        int maxidx = maxIndex(freq);
        int dkey = maxidx - 4;
        if (dkey < 0){
            dkey += 26;
        }
        return dkey;
    }
    public String decryptTwoKeys(String encrypted){
        String firstHalf = halfOfString(encrypted, 0), secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf), key2 = getKey(secondHalf);
        System.out.println(key1 + key2);
        CaesarCipher cc = new CaesarCipher();
        String message1 = cc.encrypt(firstHalf, 26-key1), message2 = cc.encrypt(secondHalf, 26-key2);
        StringBuilder message = new StringBuilder();
        
        for (int i = 0; i< Math.min(message1.length(), message2.length()); i++){
            message.append(message1.charAt(i));
            message.append(message2.charAt(i));
        }
        if (message1.length() > message2.length()){
            message.append(message1.charAt(message1.length() -1));
        }
        if (message2.length() > message1.length()){
            message.append(message2.charAt(message2.length() -1));
        }
        return message.toString();
    }
    public void testdecryptTwoKeys(){
        FileResource fr = new FileResource();
        String s = fr.asString();
        System.out.println(decryptTwoKeys(s));
    }
}
