
/**
 * Write a description of getRank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class getRank {
        public int getRank( String name, String gender ){
        int rank = -1;
        int count = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec: parser){
                             
            if(rec.get(1).equals(gender)){
            count++;
            }
            if ((rec.get(0).equals(name)) && (rec.get(1).equals(gender))){
            rank = count ;  
            }
        }
       return rank;
    }
public void testGetRank(){
    int findrank = getRank("Mich","M");
    System.out.println("the rank is "+findrank);
}

public String getName(int rank, String gender, int year){
    int count = 0;
    String name = "No Name";
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser(false);
    for(CSVRecord rec: parser){
    if (rec.get(1).equals(gender)){
        
        count++;
    }
    
    if( (count == rank)) {
        name = rec.get(0);
    }
}
return name;
}

public void testName(){
   String name =  getName(450,"M",1982);
   System.out.println("The Name is "+name);
}

public void whatisName(String name,int year, int newYear, String gender){

    int findrank = getRank(name,gender);
    String findname = getName(findrank,gender,2014);
    System.out.println( name +" born in "+year+" would be "+findname+" if she was born in "+newYear);
    
}

public void testWhatisName(){
    
    whatisName("Owen",1974,2014,"M");
    
}

public int yearOfHighestRank(String name, String gender) {
    int year = 0;
    DirectoryResource dr = new DirectoryResource();
    int startRank = 0;
    for (File f : dr.selectedFiles()) {
        FileResource fr = new FileResource(f);
        String fName = f.getName();
        String find = "yob";
        int startPos = fName.indexOf(find);
        int currYear = Integer.parseInt(fName.substring(startPos + 3, startPos + 7));
        int currRank = getRank( name, gender);
        if (year == 0){ 
            year = currYear;
            startRank = currRank;
        }
        System.out.println(startRank);
        if (currRank != -1) {
            if (currRank < startRank) {
                year = currYear;
                startRank = currRank;
            }
        }
    }
    return year;
}
    
public void testyearOfHighestRank(){
    int year = yearOfHighestRank("Mason","M");
    System.out.println("The year of highest rank is "+year);
}

/*public double getAverageRank(String name,String gender){
    int year1 = 2012;
    int highesht = 0;
    int rank1 = getRank(name, gender, year1);
    
  
    int count = 3;
    double Average = (rank1+rank2+rank3)/count;
    return Average;
}
public void testgetAverageRank(){
    double average = getAverageRank("Mason","M");
    System.out.println("The year of Average rank is "+average);
}*/

/*public int getTotalBirthsRankedHigher(int year, String name, String gender){
    
   
    int totalnames= 0;
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser(false);
    int totalBirths = 0;
    int rank = getRank(name, gender,year);
    for (CSVRecord rec : fr.getCSVParser(false)) {
	if (rec.get(1).equals(gender)) {
		rank--;
		if (rank > 0) 
			totalBirths += Integer.parseInt(rec.get(2));
	}
}
return totalBirths;
}
public void testTotalBirths(){
 int totalBirths =  getTotalBirthsRankedHigher(1990,"Emily","F"); 
 System.out.println("the total births count is "+totalBirths);
}*/
}