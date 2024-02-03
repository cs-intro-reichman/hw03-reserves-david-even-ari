/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // Replace the following statement with your code
        String uniqe ="";
         uniqe += s.charAt(0);

          for(int i =1 ; i< s.length(); i++){
            char c = s.charAt(i);
            if (s.charAt(i)==32) {
                uniqe += " ";
            }
            boolean flag = true ;
            for(int n=0 ;n< i;n++){
                
                 if (s.charAt(n)==c) {
                    flag =false ;
                 } 
                 }
                 if (flag) {
                    uniqe += c;
            }
          }

        return uniqe;
    }
}