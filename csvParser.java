
/**
 * Write a description of csvParser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class csvParser {
    
    public void countryInfo(CSVParser parser, String country){
        
        
        for(CSVRecord record : parser){
            
            if(record.get("Country").equals(country)){
            
           System.out.print(record.get("Country")+":");
           System.out.print(record.get("Exports")+":");
           System.out.println(record.get("Value (dollars)"));
           
        }
            
        }
        
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1,String exportItem2){
        
        
        for(CSVRecord record : parser){
            
            String getExports = record.get("Exports");
            
            if(getExports.contains(exportItem1) && getExports.contains(exportItem2)){
                
                String Country = record.get("Country");
                System.out.println(Country);
            }
        
            //else{
                
              //  System.out.println("Not found");
            //}
            
        }
        
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        
        int count = 0;
        for(CSVRecord record : parser){
            
            String getExports = record.get("Exports");
            
            if(getExports.contains(exportItem)){
                
               count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser,String amount){
        
        
        for(CSVRecord record : parser){
            
            String Amountlength = record.get("Value (dollars)");
            
            String country = record.get("Country");
            
            if(Amountlength.length()>amount.length()){
                
               System.out.print(country+":");
               System.out.println(Amountlength);
               
            }
        }
        
    }
    public void Tester(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton" ,"flowers");
        
        parser = fr.getCSVParser();
        int numberOfCountries = numberOfExporters(parser,"cocoa");
        System.out.println("Number of countries export cocoa is "+numberOfCountries);
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
      
    }
    

}
