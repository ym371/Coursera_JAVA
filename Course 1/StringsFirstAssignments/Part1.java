
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String dna){
        int findATG = dna.indexOf("ATG"), findTAA = dna.indexOf("TAA", findATG +3);
        if ((findATG == -1) || (findTAA == -1)){
            return "";
        }
        if ((findTAA - findATG) % 3 == 0){
            return dna.substring(findATG, findTAA + 3);
        }
        return "";
    }    
    public void testFindStopCodon(){
        String first = "AGTGTGTGTAAGG", second = "GATTGATGTTGG", third = "TGTGTGAA";
        String fourth = "TGAAATGGTGTAATTGGTAA", fifth = "TGAAATGGTTAATTGGTAA";
        System.out.println(first + ":" + findSimpleGene(first));
        System.out.println(second + ":" + findSimpleGene(second));
        System.out.println(third + ":" + findSimpleGene(third));
        System.out.println(fourth + ":" + findSimpleGene(fourth));
        System.out.println(fifth + ":" + findSimpleGene(fifth));
    }
}
