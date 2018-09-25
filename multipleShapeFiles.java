
/**
 * Write a description of multipleShapeFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class multipleShapeFiles{
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

   public double getLargestPerimeterMultipleFiles(){

    DirectoryResource dr = new DirectoryResource();
    double max = 0;
    double currentPerim = 0.0;
    for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        
         currentPerim = getPerimeter(s);
       
        if (currentPerim > max){
        max = currentPerim;
    }
    
    }
    
    return currentPerim;  
}

public String getFileWithLargestPerimeter(){
    
    DirectoryResource dr = new DirectoryResource();
    double max = 0;
    double currentPerim = 0.0;
    String filename = "";

    for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        currentPerim = getPerimeter(s);
       
        if (currentPerim > max){
        max = currentPerim;
        filename = f.getName();
    }
}

    
    return filename;  
    
}
        
    
public void testPerimeterMultipleFiles(){ 
    
    double largestPerimeterMultiple = getLargestPerimeterMultipleFiles();
    System.out.println("The Largest perimeter of all shapes is " +largestPerimeterMultiple);
    String fileName = getFileWithLargestPerimeter();
    System.out.println("The Largest perimeter filename is " +fileName);
}

}
