/**
 * A class that normalizes date-like strings to yyyy-mm-dd format.
 * 
 * @author Shiv Sharma, Andrew Dang 
 * @version 1.1
 */
public class DateNormalizer {
    /**
     * Normalizes a date-like number to the format yyyy-mm-dd.
     * Input can be separated by dash or period, and may be in reverse order.
     * 
     * @param dateStr The date string to normalize
     * @return The normalized date in yyyy-mm-dd format, or empty string if invalid
     */
    public static String normalizeDate(String dateStr) {
        if (!dateStr.matches("^\\d+[-.]\\d+[-.]\\d+$")) {
            return "";
        }
        
        String[] parts = dateStr.split("[-.]");
        

        if (parts.length != 3) {
            return "";
        }
        
        int part1, part2, part3;
        try {
            part1 = Integer.parseInt(parts[0]);
            part2 = Integer.parseInt(parts[1]);
            part3 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return "";
        }
        
        
        int year, month, day;
        
        if (part1 >= 1000 || part1 > 31) {
            // Format is yyyy-mm-dd or yyyy.dd.mm
            year = part1;
            // Check if middle part is month or day
            if (part2 <= 12 && part3 <= 31) {
                // yyyy-mm-dd
                month = part2;
                day = part3;
            } else if (part3 <= 12 && part2 <= 31) {
                // yyyy.dd.mm
                month = part3;
                day = part2;
            } else {
                return "";
            }
        } 
        else if (part3 >= 1000 || part3 > 31) {
            // Format is dd-mm-yyyy or mm.dd.yyyy
            year = part3;
            // Check if first part is month or day
            if (part1 <= 12 && part2 <= 31) {
                // mm-dd-yyyy
                month = part1;
                day = part2;
            } else if (part2 <= 12 && part1 <= 31) {
                // dd-mm-yyyy
                month = part2;
                day = part1;
            } else {
                return "";
            }
        } else {
            return "";
        }
        
        // Format as yyyy-mm-dd with two-digit month and day
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    /**
     * Main method for testing the date normalization.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        String[] testDates = {
            "2021-12-16",
            "2022.01.15",
            "15-01-2022",
            "16.12.2021",
            "14.32.2021",
            "3 Jan 2022"
        };
        
        System.out.println("Input -> Output");
        System.out.println("------------------------");
        for (String date : testDates) {
            String result = normalizeDate(date);
            System.out.printf("%-12s -> %s%n", date, result);
        }
    }
}