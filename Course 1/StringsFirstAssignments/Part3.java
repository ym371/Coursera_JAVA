
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int find1 = stringb.indexOf(stringa);
        int find2 = stringb.indexOf(stringa, find1 + stringa.length());
        if (find1 != -1 && find2 != -1){
            return true;
        }
        return false;
    }
    public void testing(){
        System.out.println("(\"by\", \"A story by Abby Long\")" + twoOccurrences("by", "A story by Abby Long"));
        System.out.println("(“zoo”, “forest”)" + twoOccurrences("zoo", "forest") );
        System.out.println("The part of the string after an in banana is " + lastPart("an", "banana"));
        System.out.println("The part of the string after zoo in forest is " + lastPart("zoo", "forest"));
    }
    public String lastPart(String stringa, String stringb){
        int find = stringb.indexOf(stringa);
        if (find == -1){ return stringb;}
        return stringb.substring(find + stringa.length(), stringb.length());
    }
}
