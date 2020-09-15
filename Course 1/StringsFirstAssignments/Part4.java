
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    public void readURLResource(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String s : ur.lines()) {
            int find = s.toLowerCase().indexOf("youtube.com");
            if (find != -1){
                int left = s.lastIndexOf("\"", find);
                int right = s.indexOf("\"", find);
                System.out.println(s.substring(left+1, right));
            }
        }
    }
}
