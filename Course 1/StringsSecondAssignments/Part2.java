
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int times = 0, start = 0;
        while (true){
            int find = stringb.indexOf(stringa, start);
            if (find == -1){
                break;
            }
            times = times + 1;
            start = find + stringa.length();
        }
        return times;
    }
    public void testHowMany(){
        System.out.println("howMany(“GAA”, “ATGAACGAATTGAATC”) = " + howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println("howMany(“AA”, “ATAAAA”)”) = " + howMany("AA", "ATAAAA") );
    }
}