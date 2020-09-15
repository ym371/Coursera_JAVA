/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int num_girlnames = 0, num_boynames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                num_boynames +=1;
            }
            else {
                totalGirls += numBorn;
                num_girlnames +=1;
            }
        }
        System.out.println("total girls' name = " + num_girlnames);
        System.out.println("total boys' name = " + num_boynames);
    }

    public void testTotalBirths () {
        FileResource fr = new FileResource("data/yob1900.csv");
        totalBirths(fr);
        fr = new FileResource("data/yob1905.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        int num = -1;
        for (CSVRecord rec: fr.getCSVParser(false)){
            String name_rec = rec.get(0), gender_rec = rec.get(1);
            int num_rec = Integer.parseInt(rec.get(2));
            if ((name.equals(name_rec)) && (gender.equals(gender_rec))){
                num = num_rec;
            }
        }
        if (num == -1){
            return -1;
        }
        
        int rank = 1;
        boolean appeared = false;
        for (CSVRecord rec: fr.getCSVParser(false)){
            String name_rec = rec.get(0), gender_rec = rec.get(1);
            int num_rec = Integer.parseInt(rec.get(2));
            if (gender_rec.equals(gender)){
                if (name_rec.equals(name) && gender_rec.equals(gender)){
                    appeared = true;
                }  
                if (num_rec > num || num_rec == num && !appeared){
                    rank = rank + 1; 
                }  
            }
        }
        return rank;
    }
    
    public void testgetRank(){
        System.out.println(getRank(1960, "Emily", "F"));
        System.out.println(getRank(1971, "Frank", "M"));
    }
    
    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for (CSVRecord rec: fr.getCSVParser(false)){
            String name_rec = rec.get(0), gender_rec = rec.get(1);
            int num_rec = Integer.parseInt(rec.get(2));
            if (gender_rec.equals(gender)){
                int rank_rec = getRank(year, name_rec, gender_rec);
                if (rank_rec == rank){
                    return name_rec;
                }
            }
        }
        return "NO NAME";
    }

    public void testgetName(){
        System.out.println(getName(1980, 350, "F"));
        System.out.println(getName(1982, 450, "M"));
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        return getName(newYear, rank, gender);
    }
    
    public void testwhatIsNameInYear(){
        System.out.println(whatIsNameInYear("Susan", 1972, 2014, "F"));
        System.out.println(whatIsNameInYear("Owen", 1974, 2014, "M"));
    }
    
    public int yearOfHighestRank(String name, String gender){
        int highest_rank = getRank(1880, name, gender), year_of_highest_rank = 1880;
        for (int year = 1881; year <=2014; year+=1){
            int rank = getRank(year, name, gender);
            if (rank != -1 && rank < highest_rank){
                highest_rank = rank;
                year_of_highest_rank = year;
            }
        }
        return year_of_highest_rank;
    }
    
    public void testyearOfHighestRank(){
        System.out.println(yearOfHighestRank("Genevieve", "F"));
        System.out.println(yearOfHighestRank("Mich", "M"));
    }
    
    public double getAverageRank(String name, String gender){
        double sum = 0;
        for (int year = 1880; year <=2014; year+=1){
            int rank = getRank(year, name, gender);
            if (rank != -1){
                sum += rank;
            }
        }
        if (sum == 0){
            return -1.0;}
        else{
            return sum/(2014-1880+1);
        }
    }
    
    public void testgetAverageRank(){
        System.out.println(getAverageRank("Susan", "F"));
        System.out.println(getAverageRank("Robert", "M"));
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int rank = getRank(year, name, gender), sum = 0;
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for (CSVRecord rec: fr.getCSVParser(false)){
            String name_rec = rec.get(0), gender_rec = rec.get(1);
            int num_rec = Integer.parseInt(rec.get(2));            
            if (gender_rec.equals(gender)){
                int rank_rec = getRank(year, name_rec, gender);
                if (rank_rec < rank){
                    sum += num_rec;
                }
            }
        }
        return sum;
    }
    
    public void testgetTotalBirthsRankedHigher(){
        //System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}