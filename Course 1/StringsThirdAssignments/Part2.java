
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public double cgRatio(String dna){
        int count_cg = 0, findc = dna.indexOf("C"), findg = dna.indexOf("G");
        while(findc != -1 || findg != -1){
            if (findc != -1){
                count_cg = count_cg +1;
                findc = dna.indexOf("C", findc + 1);
            }
            if (findg != -1){
                count_cg = count_cg +1;
                findg = dna.indexOf("G", findg + 1);
            }
        }
        return (double)(count_cg) / dna.length();            
    }
    public void testcgRatio(String dna){
        System.out.println(cgRatio(dna));
    }
}
