
/**
 * Write a description of newCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class newCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public newCaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        String lower = alphabet.toLowerCase(), shiftedLower = shiftedAlphabet.toLowerCase();
        
        for (int i = 0; i< encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int index_upper = alphabet.indexOf(currChar);
            int index_lower = lower.indexOf(currChar);
            if (index_upper != -1){
                char new_char = shiftedAlphabet.charAt(index_upper);
                encrypted.setCharAt(i, new_char);
            }
            else if (index_lower != -1){
                char new_char = shiftedLower.charAt(index_lower);
                encrypted.setCharAt(i, new_char);
            }
        }
        return encrypted.toString();
    }
    public String decrypt(String input){
        newCaesarCipher cc = new newCaesarCipher(26- mainKey);
        return cc.encrypt(input);
    }
        
}
