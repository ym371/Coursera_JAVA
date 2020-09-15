import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int find = dna.indexOf(stopCodon, startIndex);
        while (find != -1){
            if ((find - startIndex) %3 == 0){
                return find;
            }
            find = dna.indexOf(stopCodon, find + 3);
        }
        return dna.length();
    }
    public String findGene(String dna){
        int start = dna.indexOf("ATG");
        if (start == -1){
            return "";
        }
        int end1 = findStopCodon(dna, start + 3, "TAA");
        int end2 = findStopCodon(dna, start + 3, "TAG");
        int end3 = findStopCodon(dna, start + 3, "TGA");
        int end = Math.min(end1, Math.min(end2,end3));
        if (end == dna.length()){
            return "";
        }
        return dna.substring(start, end + 3);        
    }
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int start_index = 0;
        while (true){
            String dna_sub = dna.substring(start_index);
            String gene = findGene(dna_sub);
            if (gene == "") {break;}
            geneList.add(gene);
            start_index = dna.indexOf(gene, start_index) + gene.length();
        }
        return geneList;
    }
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
    public void processGenes(StorageResource sr){
        int count = 0, max = 0;
        System.out.println("Strings in sr taht are longer than 60 characters are");
        
        for (String s: sr.data()){
            if (s.length() > 60){
                System.out.println(s);
                count += 1;
            }
            if (s.length() > max){
                max = s.length();
            }
        }
        System.out.println("total number = " + count);
        count = 0;
        System.out.println(" Strings in sr whose C-G-ratio is higher than 0.35 are");
        for (String s: sr.data()){
            if (cgRatio(s) > 0.35){
                System.out.println(s);
                count += 1;
            }
        }
        System.out.println("total number = " + count);
        System.out.println("longest length = " + max);
    }
    public void testProcessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
        int count = 0, findCTG = dna.indexOf("CTG");
        while (findCTG != -1){
            count +=1;
            findCTG = dna.indexOf("CTG", findCTG +1);
        }
        System.out.println("number of CTG = " + count);
    }
}
