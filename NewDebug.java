
/**
 * Write a description of NewDebug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewDebug {
    
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if ((index == -1) || (index >= input.length()-3)){
            break;
        }
        //System.out.println(index+1);
        //System.out.println(index+4);
        String found = input.substring(index+1, index+4);
         System.out.println(index);
        System.out.println(found);
         index = input.indexOf("abc", index+3);
    }
}
   public void test() {
    
       //findAbc("abcd");
       findAbc("abcabcabcabca");
}
}
