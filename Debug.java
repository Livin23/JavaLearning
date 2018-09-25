
/**
 * Write a description of Debug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debug {
    
   public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           //System.out.println(index);
           
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           /*if(index >=30){
               index = -1;
            }*/
            
            //System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       //findAbc("abcabcabcabca");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
}

}
