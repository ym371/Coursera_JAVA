
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene (String dna, String startCodon, String stopCodon){
        if (dna != dna.toUpperCase() && dna != dna.toLowerCase()){
            return "";
        }
        int findstart = dna.indexOf(startCodon), findstop = dna.indexOf(stopCodon, findstart +3);
        if ((findstart == -1) || (findstop == -1)){
            return "";
        }
        if ((findstop - findstart) % 3 == 0){
            return dna.substring(findstart, findstop + 3);
        }
        return "";
    }    
    public void testFindStopCodon(){
        String first = "AGTGTGTGTAAGG", second = "GATTGATGTTGG", third = "TGTGTGAA";
        String fourth = "TGAAATGGTGTAATTGGTAA", fifth = "TGAAATGGTTAATTGGTAA";
        System.out.println(first + ":" + findSimpleGene(first, "ATG", "TAA"));
        System.out.println(second + ":" + findSimpleGene(second, "ATG", "TAA"));
        System.out.println(third + ":" + findSimpleGene(third, "ATG", "TAA"));
        System.out.println(fourth + ":" + findSimpleGene(fourth, "ATG", "TAA"));
        System.out.println(fifth + ":" + findSimpleGene(fifth, "ATG", "TAA"));
    }
}
