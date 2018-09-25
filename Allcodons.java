
/**
 * Write a description of Allcodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Allcodons {
    
    public int stopCodonIndex(String dnaStr, int startIndex, String stopCodon){
        
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        
        while(currIndex !=-1){
            
            if((currIndex - startIndex)%3 == 0){
                
                return currIndex;
               }
             else {
                currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
                }
            }
        
    return dnaStr.length();
    }

    public String findGenes(String dna, int start){
        
        int startIndex = dna.indexOf("ATG", start);
        if ((startIndex == -1)){
            
            return "";
        }
        
       int tagIndex = stopCodonIndex( dna, startIndex,"TAG");
       int tgaIndex = stopCodonIndex( dna, startIndex,"TGA");
       int taaIndex = stopCodonIndex( dna, startIndex,"TAA");
       //int minIndex = Math.min(tagIndex,Math.min(tgaIndex,taaIndex));
       int minIndex = 0;
      
       if ((tagIndex == -1) || ((tgaIndex != -1)&&(tgaIndex<taaIndex))){
            minIndex = tgaIndex ;
               }
        else{
            minIndex = tagIndex;
        }
        
        if ((minIndex ==-1) || ((taaIndex != -1)&&(taaIndex<minIndex))){
            minIndex = taaIndex;
        }
        
        if (minIndex ==-1){
               return "";
                   }
         if(startIndex>(dna.length()-3)){
          return dna.substring(startIndex, minIndex+3);   
        }
        else        
        {return dna.substring(startIndex, minIndex); 
        }
          }
    public void PrintAllGenes(String dna){
        
       int startIndex = 0;
       while (true){
           
           String currGene =  findGenes(dna, startIndex);
           if (currGene.isEmpty()){
               
              break;
            } 
            System.out.println(currGene);
    
        startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
    }
    }
    public int countGenes(String dna){
        
       int startIndex = 0;
       int count = 0;
       while (true){
           
           String currGene =  findGenes(dna, startIndex);
           if (currGene.isEmpty()){
               
              break;
            } 
            System.out.println(currGene);
    
        startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
          ++count;
    }
    return count;
    }
    
    public void testCountGenes(){
        
        String dna = "ATGGFVTAAATGUTYTGAGHJATGUIOTAG";
        
        int count = countGenes(dna);
        
        System.out.println("Count is "+count);
        
        
    
}

    public StorageResource getAllGenes(String dna){
        
        StorageResource genelist = new StorageResource();
        
        int startIndex = 0;
        
        while(true) {
            
            String currGene = findGenes(dna, startIndex);
            
            if(currGene.isEmpty()){
                
                break;
            }
            
            genelist.add(currGene);
            startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        
    }
return genelist;
}

public void testStorage(String dna){
    
    StorageResource genes = getAllGenes(dna);
    for( String g:genes.data()){
        System.out.println(g);
    }   
    
}
 public int howMany( String stringa, String stringb){
        
        int count = 0;
        
        int curindex = 0;
        int starndex = 0;
        
        while( curindex != -1){
                      
            
            curindex= stringb.indexOf(stringa,starndex);
            count = count+1;
            starndex = curindex+ stringa.length();
                            
            
        }
        return count-1;
    }
    
    public float cgRatio(String dna){
        
        String Cnumb ="C";
        String Gnumb = "G";
        //String dna = "ATGCCATAG";
                
        int countC = howMany(Cnumb,dna);
        System.out.println("Count of C is "+countC);
        int countG = howMany(Gnumb,dna);
        System.out.println("Count of G is "+countG);
        
        int totgene = countC+countG;
        int totlength = dna.length();
        System.out.println("TotalCG is "+totgene);
        System.out.println("totlength is "+totlength);
        float cgrat = (float)totgene/totlength;
        return cgrat;
      
        
    }

public void processGenes(StorageResource sr){
    
    String dna;
    
    int count = 0;
    int countratio = 0;
    int max = 0;
    
    
    for( String g:sr.data()){
        if (g.length()>9){
        System.out.println(g);
        count = count+1;
    }
    System.out.println(count);
    }   
    
    for( String g:sr.data()){
        float ratios = cgRatio(g);
        if (ratios>0.35){
        System.out.println(g);
        countratio = count+1;
    }
    System.out.println(countratio);
    }   
    for( String g:sr.data()){
        
        if (max>g.length()){
         max = g.length();
         System.out.println(g);
        }
    
}
    
    }  
    
public void testProcessGenes(){
    
    DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
                 String dna = fr.asString().toUpperCase();
   PrintAllGenes(dna);
    int count = 0;
    int countratio = 0;
    int max = 0;
    
    
    for( String g:sr.data()){
        //if (g.length()>9){
        System.out.println(g);
        count = count+1;
    //}
    System.out.println(count);
    }   
    
    

}
    
    
 }  
    
}
    
