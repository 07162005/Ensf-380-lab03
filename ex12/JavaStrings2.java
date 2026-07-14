import java.util.regex.Pattern;

/**
 * A class that provides various String manipulation methods using regex.
 * 
 * @author Shiv Sharma, Andrew Dang
 * @version 2.1
 */
public class JavaStrings2 {
    
    /** Pattern for replacing vowels with 'z' */
    private static final Pattern SECRET_CODE_REGEX = Pattern.compile("[aeiouAEIOU]");
    
    /**
     * Getter for the SECRET_CODE_REGEX pattern.
     * 
     * @return The Pattern object for secret code encoding
     */
    public static Pattern getSecretCodeRegex() {
        return SECRET_CODE_REGEX;
    }
    
    /**
     * Trims whitespace from two Strings, concatenates them, and returns the length.
     * 
     * @param str1 The first String
     * @param str2 The second String
     * @return The length of the trimmed and concatenated String
     */
    public static int addTogether(String str1, String str2) {
        String trimmed1 = str1.trim();
        String trimmed2 = str2.trim();
        String concatenated = trimmed1 + trimmed2;
        return concatenated.length();
    }
    
    /**
     * Creates a unique identifier for veterinary clinic clients.
     * Format: Owner's first initial + Owner's last initial + Pet's first initial + Year
     * 
     * @param firstName The owner's first name
     * @param lastName The owner's last name
     * @param petName The pet's name
     * @param year The pet's year of birth
     * @return The formatted identifier String
     */
    public static String idProcessing(String firstName, String lastName, 
                                      String petName, int year) {
        return firstName.substring(0, 1) + 
               lastName.substring(0, 1) + 
               petName.substring(0, 1) + 
               year;
    }
    
    /**
     * Encodes a String by replacing vowels with 'z' and taking only the first 3 characters.
     * Uses the SECRET_CODE_REGEX Pattern instead of String methods.
     * 
     * @param ingredient The ingredient name to encode
     * @return The encoded secret code
     */
    public static String secretCode(String ingredient) {
        // Use the Pattern to replace vowels with 'z'
        String encoded = SECRET_CODE_REGEX.matcher(ingredient).replaceAll("z");
        
        // Return only the first 3 characters
        return encoded.substring(0, 3);
    }
    
    /**
     * Example main method demonstrating all functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("addTogether(\" Hello \", \" World \") = " + 
                          addTogether(" Hello ", " World "));
        System.out.println("idProcessing(\"Emma\", \"Doe\", \"Max\", 2010) = " + 
                          idProcessing("Emma", "Doe", "Max", 2010));
        System.out.println("secretCode(\"tomato\") = " + secretCode("tomato"));
        System.out.println("secretCode(\"POTATO\") = " + secretCode("POTATO"));
        System.out.println("secretCode(\"basil\") = " + secretCode("basil"));
    }
}