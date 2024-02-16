public class UniqueChars {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java UniqueChars <string>");
            return;
        }
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // Using StringBuilder for efficient string manipulation
        StringBuilder unique = new StringBuilder();
        unique.append(s.charAt(0)); // Append the first character
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the character is a space, append it directly
            if (c == ' ') {
                unique.append(' ');
            } else {
                boolean isDuplicate = false;
                // Check if the character is a duplicate
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == c) {
                        isDuplicate = true;
                        break;
                    }
                }
                // Append the character if it's not a duplicate
                if (!isDuplicate) {
                    unique.append(c);
                }
            }
        }
        return unique.toString();
    }
}