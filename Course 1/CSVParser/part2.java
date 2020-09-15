
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class part2 {
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        double coldest = 0;
        CSVRecord coldest_record = null;
        for (CSVRecord record: parser){
            double temperature = Double.parseDouble(record.get("TemperatureF"));
            if ((temperature < coldest || coldest_record == null) && temperature != -9999){
                coldest = temperature;
                coldest_record = record;
            }
        }
        return coldest_record;
    }
    public String fileWithColdestTemperature (){
        DirectoryResource dr = new DirectoryResource();
        double coldest = 0;
        File coldest_file = null;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord coldest_infile_rec = coldestHourInFile(parser);
            double coldest_infile = Double.parseDouble(coldest_infile_rec.get("TemperatureF"));
            if (coldest_file == null || coldest_infile < coldest){
                coldest = coldest_infile;
                coldest_file = f;
            }
        }
        return coldest_file.getName();
        
    }
    public void testfileWithColdestTemperature(){
        String coldest_file_name = fileWithColdestTemperature ();
        System.out.println("Coldest day was in file " + coldest_file_name);
        
        FileResource fr = new FileResource("2013/"+coldest_file_name);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest_rec = coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + coldest_rec.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were ");
        parser = fr.getCSVParser();
        for (CSVRecord record: parser){
            String date = record.get("DateUTC"), temperature = record.get("TemperatureF");
            System.out.println(date + " : " + temperature);
        }
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        double lowestHumidity = 0;
        CSVRecord lowestHumidity_record = null;
        for (CSVRecord record: parser){
            String humidity = record.get("Humidity");
            if (humidity != "N/A"){
                double humidity_value = Double.parseDouble(humidity);
                if ((humidity_value < lowestHumidity || lowestHumidity_record == null)){
                    lowestHumidity = humidity_value;
                    lowestHumidity_record = record;
                }
            }
        }
        return lowestHumidity_record;
    }
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        double lowestHumidity = 0;
        CSVRecord lowestHumidity_record = null;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord lowestHumidity_infile = lowestHumidityInFile(parser);
            double lowestHumidityValue_infile = Double.parseDouble(lowestHumidity_infile.get("Humidity"));
            if (lowestHumidity_record == null || lowestHumidityValue_infile < lowestHumidity){
                lowestHumidity = lowestHumidityValue_infile;
                lowestHumidity_record = lowestHumidity_infile;
            }
        }
        return lowestHumidity_record;
        
    }
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    public double averageTemperatureInFile(CSVParser parser){
        double sum_temp = 0, num_temp = 0;
        for (CSVRecord record: parser){
            double temperature = Double.parseDouble(record.get("TemperatureF"));
            if (temperature != -9999){
                sum_temp += temperature;
                num_temp += 1;
            }
            
        }
        return sum_temp / num_temp;
    }
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.print("Average temperature in file is " + averageTemperatureInFile(parser));
    }   
    public void averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum_temp = 0, num_temp = 0;
        boolean flag = true;
        for (CSVRecord record: parser){
            double temperature = Double.parseDouble(record.get("TemperatureF"));
            String humidity = record.get("Humidity");
            if (humidity != "N/A"){
                double humidity_value = Double.parseDouble(humidity);
                if (temperature != -9999 && humidity_value >= value  ){
                    sum_temp += temperature;
                    num_temp += 1;
                    flag = false;
                }
            }
        }
        if (flag){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average Temp when high Humidity is " + sum_temp / num_temp);
        }
    }
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        averageTemperatureWithHighHumidityInFile(parser, 80);
    }   
}
