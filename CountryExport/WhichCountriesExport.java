package CountryExport;

import edu.duke.*;
import org.apache.commons.csv.*;
    public class WhichCountriesExport {
 public void listExporters(CSVParser
 parser, String exportOfInterest) {
    for (CSVRecord record : parser){
    String export = record.get("Exports");
    
    if (export.contains(exportOfInterest)) {
    String country = record.get("Country");
    System.out.println(country);
    }
    }
  
    }
    
 public void whoExportsCoffee() {
    FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser();
     listExporters(parser, "coffee");
    }
    
 public void tester(String s){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    parser = fr.getCSVParser();
    //numberOfExporters(parser, s);
    bigExporters(parser, s);
    //System.out.println( countryInfo(parser,s));
    //return parser;
    }
    
 public String countryInfo(CSVParser parser, String country){
    for (CSVRecord record : parser){
    String c = record.get("Country");
    if(c.contains(country)){
     return c+": "+record.get("Exports")+": "+record.get(2);
    }
    }
    return country+": "+"NOT FOUND";
}
    public void listCountriesTwoExports(CSVParser parser, String export1, String export2){
    for (CSVRecord record : parser){
    String c = record.get("Exports").toLowerCase();
    if(c.contains(export1.toLowerCase())&& c.contains(export2.toLowerCase())){
    System.out.println(record.get("Country"));
    }
    }
    
    }
    public void Test2Exports(String export1, String export2){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    parser = fr.getCSVParser();
    listCountriesTwoExports(parser, export1, export2);
    }

    public int numberOfExporters(CSVParser parser, String exportitem){
    FileResource fr = new FileResource();
    parser = fr.getCSVParser();
    int count=0;
    for (CSVRecord record : parser){
    String c = record.get("Exports").toLowerCase();
    if(c.contains(exportitem.toLowerCase())){
    count++;
    }
    }
    System.out.println(count);
    return count;
    }
    public void bigExporters(CSVParser parser, String amount) {
    FileResource fr = new FileResource();
    parser = fr.getCSVParser();
    for (CSVRecord record : parser){
    String c = record.get(2).toLowerCase();
    String num = c.replace("$","").replace(",","");
    amount = amount.replace("$","").replace(",","");
 
    if (num.length()>amount.length()) {
    String g = record.get(0); //get countries
    System.out.println(g +" : "+ c);
    }
    }
    
    }
    
    }

