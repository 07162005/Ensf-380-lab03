import java.util.Arrays;

/**
 * A class that manages a 4-element array of Strings with various operations.
 */
public class SimpleArrays {
    /** The 4-element array of Strings */
    private String[] array;
    
    /**
     * Default constructor that initializes the array with "Hello, world".
     */
    public SimpleArrays() {
        this("Hello, world");
    }
    
    /**
     * Constructor that initializes the array with the given String.
     * @param str the String to fill the array with
     */
    public SimpleArrays(String str) {
        array = new String[4];
        Arrays.fill(array, str);
    }
    
    /**
     * Concatenates all elements from index 0 to the end.
     * @return a String of concatenated elements separated by '#'
     */
    public String arrayConcat() {
        return arrayConcat(0);
    }
    
    /**
     * Concatenates all elements from the given index to the end.
     * @param index the starting index
     * @return a String of concatenated elements separated by '#'
     * @throws IndexOutOfBoundsException if index is outside array bounds
     */
    public String arrayConcat(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = index; i < array.length; i++) {
            if (i > index) {
                result.append("#");
            }
            result.append(array[i]);
        }
        return result.toString();
    }
    
    /**
     * Crops the array between two indices (inclusive) and concatenates the elements.
     * @param start the starting index
     * @param end the ending index
     * @return concatenated elements separated by '#', "Match" if indices are equal,
     *         or "Fail" if either index is invalid
     */
    public String arrayCrop(int start, int end) {
        // Check if both indices are valid
        if (start < 0 || start >= array.length || end < 0 || end >= array.length) {
            return "Fail";
        }
        
        // If indices are the same, return "Match"
        if (start == end) {
            return "Match";
        }
        
        // Swap if end is smaller than start
        if (end < start) {
            int temp = start;
            start = end;
            end = temp;
        }
        
        // Use arrayConcat to do the actual concatenation
        // But we need to concatenate from start to end (inclusive)
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i > start) {
                result.append("#");
            }
            result.append(array[i]);
        }
        return result.toString();
    }
    
    /**
     * Example main method demonstrating the functionality.
     */
    public static void main(String[] args) {
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat();
        System.out.println(foundResult1);
        
        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2);
        
        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat();
        System.out.println(foundResult3);
        
        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4);
        
        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);
        
        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);
        
        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);
        
        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
    }
}