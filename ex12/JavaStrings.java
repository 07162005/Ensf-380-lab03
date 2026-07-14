import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * A class that provides various String manipulation methods using regex.
 * 
 * @author Shiv Sharma, Andrew Dang
 * @version 1.1
 */

public class JavaStrings {
    public static void main(String[] args) {

        String myString = "ENSF Principles of Software Development";

        // 1 & 2. Count both uppercase and lowercase 'E'
        Pattern pattern = Pattern.compile("[eE]");
        Matcher matcher = pattern.matcher(myString);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println("Number of E/e characters: " + count);

        // 3. Split by whitespace and print each token
        String[] tokens = myString.split("\\s+");

        System.out.println("\nTokens:");
        System.out.println("Number of tokens: " + tokens.length);

        for (String token : tokens) {
            System.out.println(token);
        }

        // 4. Insert a colon after "ENSF"
        StringBuilder sb = new StringBuilder(myString);
        sb.insert(4, ":");

        System.out.println("\nUpdated String:");
        System.out.println(sb);
    }
}