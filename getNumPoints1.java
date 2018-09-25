
/**
 * Write a description of getNumPoints1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import edu.duke.Shape;
public class getNumPoints1 {
    
    public int getNumPoint1(Shape s){
        int count = 0;
        for(Point p: s.getPoints()){
            
            count = count+1;
        }
        return count;
    }
    
    public double getAverageLength(Shape s){
        double count = 0;
        double totalDist = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalDist = totalDist+currDist;
            count = count+1;
            prevPt = currPt;
        }
        double Average =  totalDist/count;
        return Average;
    }
    
    public double getLargestSide(Shape s){
        
        double max = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if ( currDist > max){
                
                max = currDist;
                
            }
            prevPt = currPt;
            
        }
          
            return max;
    }
    public double getLargestX(Shape s){
        
        double maxX= 0;
        for (Point p:s.getPoints()){
            
            double valueX = p.getX();
            
            if ( valueX > maxX){
                
                maxX = valueX ;
                
            }
            
        }
        
        return maxX ;
        
       
    }
       
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int totalCount = getNumPoint1(s);
        System.out.println("The total number of points is "+totalCount);
        double averagelenght = getAverageLength(s);
        System.out.println("Average length is "+averagelenght);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side is "+largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X is "+largestX);
    }

}
