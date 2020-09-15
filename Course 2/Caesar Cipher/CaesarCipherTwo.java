
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1, mainkey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainkey1 = key1;
        mainkey2 = key2;
    }
    private String halfOfString (String message, int start){
        StringBuilder s = new StringBuilder();
        for (int i = start; i< message.length(); i+= 2){
            s.append(message.charAt(i));
        }
        return s.toString();
    }
    public String encrypt(String input){
        String firstHalf = halfOfString(input, 0), secondHalf = halfOfString(input, 1);
        newCaesarCipher cc1 = new newCaesarCipher(mainkey1);
        newCaesarCipher cc2 = new newCaesarCipher(mainkey2);
        String message1 = cc1.encrypt(firstHalf), message2 = cc2.encrypt(secondHalf);
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
}
