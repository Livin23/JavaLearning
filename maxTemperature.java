    
/**
 * Write a description of maxTemperature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class maxTemperature {
    
    public CSVRecord hottestHour(CSVParser parser){
        
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow: parser){
            
            largestSoFar = largetsof2Days(currentRow,largestSoFar);
            /*if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp>largestTemp){
                    
                    largestSoFar = currentRow;
                }
            } */
            
        }
        
        
        return largestSoFar;
    }
    
    public CSVRecord hottestinDays(){
        
       CSVRecord largestSoFar = null;
       
       DirectoryResource dr = new  DirectoryResource();
       
       for(File f:dr.selectedFiles()){
           
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = hottestHour(fr.getCSVParser());
           
           largestSoFar = largetsof2Days(currentRow,largestSoFar);
            
            /*if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp>largestTemp){
                    
                    largestSoFar = currentRow;
                }
            } */
        
           
        
    }
        
        return largestSoFar;
    }

    public CSVRecord largetsof2Days(CSVRecord currentRow,CSVRecord largestSoFar){
        
               if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp<largestTemp){
                    
                    largestSoFar = currentRow;
                }
            }
        
        return largestSoFar;
    }
    
    public void Testhotestday(){
        
        //FileResource fr = new FileResource();
        //CSVRecord largest = hottestHour(fr.getCSVParser());
        //System.out.println("The hottets hour is "+largest.get("TemperatureF")+" at time "+ largest.get("TimeEST"));
        
        CSVRecord largestinMany = hottestinDays();
        System.out.println("The temp is "+largestinMany.get("TemperatureF")+" at time "+ largestinMany.get("DateUTC"));
        
    }

}
