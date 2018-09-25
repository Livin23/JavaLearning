
/**
 * Write a description of LowestHumidity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class LowestHumidity {

    public CSVRecord lowestHumidityday(CSVParser parser){
        
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow: parser){
            
            largestSoFar = largetsof2Days(currentRow,largestSoFar);
    
        }
        
         return largestSoFar;
}

public CSVRecord lowestHumiditydaysofall(){
        
       CSVRecord largestSoFar = null;
       
       DirectoryResource dr = new  DirectoryResource();
       
       for(File f:dr.selectedFiles()){
           
           FileResource fr = new FileResource(f);
           CSVRecord currentRow = lowestHumidityday(fr.getCSVParser());
           
           largestSoFar = largetsof2Days(currentRow,largestSoFar);
        }
    return largestSoFar;
}

public CSVRecord largetsof2Days(CSVRecord currentRow,CSVRecord largestSoFar){
    
     double currentTemp = 0;
     double largestTemp = 0;
        
               if (largestSoFar == null){
                largestSoFar = currentRow;
            }
            
            else{
                                             
               String currhumid = currentRow.get("Humidity");
               
               if( currhumid.contains("N/A")){
                   
                   currentTemp = 0;
                   
                }
                
                else{
                currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                largestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
                
            }
                if(currentTemp<largestTemp){
                    
                    largestSoFar = currentRow;
                }
            }
        
        return largestSoFar;
    }

public void humidday(){
        
        //FileResource fr = new FileResource();
        //CSVRecord largest = lowestHumidityday(fr.getCSVParser());
        //System.out.println("The lowest humid is "+largest.get("Humidity")+" at time "+ largest.get("DateUTC"));
        
        CSVRecord largestinMany = lowestHumiditydaysofall();
        System.out.println("The lowest humid for year is "+largestinMany.get("Humidity")+" at time "+ largestinMany.get("DateUTC"));
        
    }

}
