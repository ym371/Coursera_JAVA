
/**
 * Write a description of testNewCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class testNewCaesarCipher {
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
    public void simpleTests(){
        FileResource fr = new FileResource();
        String s = fr.asString();
        newCaesarCipher cc = new newCaesarCipher(15);
        String encrypted = cc.encrypt(s);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        testNewCaesarCipher tcc = new testNewCaesarCipher();
        System.out.println(tcc.breakCaesarCipher(encrypted));
    }
    public String breakCaesarCipher(String encrypted){
        
        int[] freq = countLetters(encrypted);
        int maxidx = maxIndex(freq);
        int dkey = maxidx - 4;
        if (dkey < 0){
            dkey = dkey + 26;
        }
        newCaesarCipher cc = new newCaesarCipher(dkey);
        return cc.decrypt(encrypted);
    }
}
