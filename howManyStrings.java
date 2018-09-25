
/**
 * Write a description of howManyStrings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class howManyStrings {
    
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
    
    public float cgRatio(){
        
        String Cnumb ="C";
        String Gnumb = "G";
        String dna = "ATGCCATAG";
                
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
    
    public void testHowMany(){
        
        String stringa = "CTG";
        
        String stringb = "ATGCCATACCCGGTACTG";
        
        int numb = howMany(stringa,stringb);
        
        System.out.println("Count of CTG is "+numb);
              
       
        float cgration = cgRatio();
        System.out.println("cgration is " +cgration);
        
        
    }

}
