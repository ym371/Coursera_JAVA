
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class part1 {
    public void tester(){
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Germany"));
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //parser = fr.getCSVParser();
        //System.out.println(numberOfExporters(parser, "cocoa"));
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record: parser){
            String input_country = record.get("Country"), exports = record.get("Exports"), value = record.get("Value (dollars)");
            if (input_country.equals(country)){
                return country + ": " + exports + ": " + value;
            }
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record: parser){
            String country = record.get("Country"), exports = record.get("Exports"), value = record.get("Value (dollars)");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(country);
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record: parser){
            String country = record.get("Country"), exports = record.get("Exports"), value = record.get("Value (dollars)");
            if (exports.contains(exportItem)){
                count += 1;
            }
        }
        return count;
    }
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record: parser){
            String country = record.get("Country"), exports = record.get("Exports"), value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                System.out.println(country + " " + value);
            }
        }
    }
}
