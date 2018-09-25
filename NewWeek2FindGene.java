
/**
 * Write a description of NewWeek2FindGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewWeek2FindGene {
    
    public String findGene(String dna){
        
        int startIndex = dna.indexOf("ATG");
        
        int currIndex = dna.indexOf("TAA", startIndex+3);
        
        while(currIndex !=-1){
            
            if((currIndex-startIndex)%3 ==0){
                
                return dna.substring(startIndex,currIndex+3);
                
            }
            else {
                
                currIndex = dna.indexOf("TAA", currIndex+1);
                
            }
        }
    
        return "";
}

public void testFindGene(){
    
    String dna = "ATGHUSFGHTAA";
    System.out.println("DNA is "+dna);
    String gene = findGene(dna);
    System.out.println("Gene is "+gene);
    
     dna = "ASWATGHUSFGHTAAGHJ";
    System.out.println("DNA is "+dna);
     gene = findGene(dna);
    System.out.println("Gene is "+gene);
    
    
    
}

}
