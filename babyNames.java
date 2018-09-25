
/**
 * Write a description of babyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class babyNames {
    
    public void totalBirths(FileResource fr){
        
        int countOfBoys = 0;
        int countOfGirls = 0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            
            if(rec.get(1).equals("M")){
                
                countOfBoys++;
            }
            else{
                countOfGirls++;
            }
        }
        System.out.println("The total number of girls are "+countOfGirls);
        System.out.println("The total number of boys are "+countOfBoys);
    }
    
    public int getRank(String name, String gender){
        
        int rank = 0;
        int count = 0;
        //DirectoryResource dr =  new DirectoryResource();
        //for(File f:dr.selectedFiles()){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec: parser){
            
            rank++;
            //&& f.getName().contains("year")
            
            if ((rec.get(0).equals("name")) && (rec.get(1).equals("gender"))){
                
               return rank;
            }
            
           else{
               
               rank = -1;
               
            }
        }
    //}
        return rank;
    }

    public String getName(int rank, String gender){
        int rankgiven = 0;
        String name = "";
        DirectoryResource dr =  new DirectoryResource();
        for(File f:dr.selectedFiles()){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec: parser){
            
            rankgiven = (int)parser.getCurrentLineNumber();
          
            
            if ( rankgiven == rank && rec.get(1).equals("gender") && f.getName().contains("year")){
                
                name = rec.get(0);
                
            }
        else {
            
            return "No Name";
            
        }
        
    }
    
}
        
        return name;
    }
    
    
public void testtotalBirths(){
    
    FileResource fr = new FileResource();
    
    totalBirths(fr);
    
}

public void testRank(){
    
    int ranks = getRank("Isabella","F");
    System.out.println("The rank is "+ranks);
}
    
}
