
/**
 * Write a description of NewFInd3Codons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class NewFInd3Codons {
    
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        
        while (currIndex!=-1){
        
            if ((startIndex - currIndex)%3 == 0){
                
                return currIndex;               
            }
            else{
             currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
                }
                    
        }
        return -1;
    }
    
    public String findGene(String dna, int where){
        
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex ==-1){
            return "";
          }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int minIndex = 0;
       if((taaIndex ==-1 || (tgaIndex !=-1 && tgaIndex<taaIndex))){
           
           minIndex = tgaIndex;
           
        }
        else {
            
            minIndex =taaIndex;
        }
        
        if((minIndex ==-1||(tagIndex !=-1 && tagIndex<minIndex))){
           
           minIndex = tagIndex;
           
        }
                
        if (minIndex == -1){
            return "";
        }
        
            
       return dna.substring(startIndex,minIndex+3);
        
    }
    
    public void printGenes(String dna){
        
        int startIndex = 0;
        
        while(true){
            
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                
                break;
            }
            System.out.println(currentGene);
            
            startIndex = dna.indexOf(currentGene,startIndex) + currentGene.length();
            
        }
        
        
        
    }
     public StorageResource storeGenes(String dna){
        
         StorageResource gene = new StorageResource();
         
        int startIndex = 0;
        
        while(true){
            
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                
                break;
            }
            gene.add(currentGene);
            
            startIndex = dna.indexOf(currentGene,startIndex) + currentGene.length();
            
        }
        
        
        return gene;
    }
   
    public double cgRatio(String dna){
        int Currcindex = 0;
        int CurrGindex = 0;
        
        int countC = 0;
        int countG = 0;
        
        while (true){
          
        int CRation = dna.indexOf("C", Currcindex);
                        
        if ( CRation ==-1){
            
            break;
            
        }
         else{
            countC++;
            Currcindex = CRation+1;
            
        }
            
        }
        
        while(true){
        int GRation = dna.indexOf("G",CurrGindex );
        
         if ( GRation ==-1){
             
             break;
             
            }
            
           else{
            countG++;
            CurrGindex = GRation+1;
        }
        
    }
        
        int totalCG = countC +countG;
        
        double cgRatio = ((double) totalCG)/dna.length();
        
        return cgRatio;
       
    }
    
    public int countCTG(String dna)
   {   int start = 0; int count3 = 0; 
       while(true)
       {
           int CTGcount = dna.indexOf("CTG",start);
           if(CTGcount != -1)
           {
               count3++;
               start = CTGcount + 3;
           }
           else
           {
               break;
           }
       }
       return count3;
   }
   
        
    public void processGenes(StorageResource sr){
        
      
        int count = 0;
        double cgRatio = 0;
        int cgRatioCount = 0;
        int maxLength = 0;
        int countGene = 0;
        int countCTG = 0;
        String longString = "";
                  
            for(String genes: sr.data()){
                
                countGene++;
                if (genes.length()>60){
                    
                    System.out.println("the strings greater than 60 "+genes);
                    
                    count++;
                }
                System.out.println("the count of strings greater than 60 "+count);
                
                cgRatio = cgRatio(genes);
                System.out.println("Cgration value is" +cgRatio);
                if (cgRatio > 0.35) {
                    
                    System.out.println("The strings that are greater ratio are "+genes); 
                    
                    cgRatioCount++;
                }
                
                System.out.println("the count of strings greater than cgratio "+cgRatioCount);
                
                
                
                if(genes.length()>maxLength){
                    
                    
                    
                    maxLength = genes.length();
                    longString = genes;
                }
                
                System.out.println("the maxlenght of gene is "+maxLength);
                System.out.println("the long gene is "+longString);
                
                countCTG = countCTG(longString);
                
                System.out.println("The count of CTG genes are "+countCTG); 
                              
                
                
            
        } 
                
        System.out.println("The total count of genes is "+countGene);
    }
    
    public void TestprocessGenes(){
         DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
        FileResource fr = new FileResource(f);
        String dna = fr.asString().toUpperCase();
        StorageResource sr = storeGenes(dna);
        printGenes(dna);
        cgRatio(dna);
        processGenes(sr);
        
        }
    
}

}
