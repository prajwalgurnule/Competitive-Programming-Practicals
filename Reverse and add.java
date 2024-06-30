import java.util.Scanner;
class Main {  
    // Method to reverse a number
    public static long reverseNumber(long num) {
        long reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10; // Extract digits from right to left
            num /= 10; // Move to the next digit
        }
        return reversed;
    } 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt(); // Read the number of test cases
        
        // Process each test case
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int repeatCount = 0; // Initialize repeat count
            long num = scanner.nextLong(); // Read the input number
            
            // Reverse the number
            long reversed = reverseNumber(num);
            
            // Repeat until the number becomes palindrome
            while (num != reversed) {
                num += reversed; // Add the reversed number to the original number
                reversed = reverseNumber(num); // Reverse the new number
                repeatCount++; // Increment repeat count
            }           
            // Output the result
            System.out.println(repeatCount + " " + num);
        }       
        scanner.close(); // Close the scanner
    }
}
