import java.util.Scanner;
class Main {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Keep reading input until there's no more input
        while (scanner.hasNext()) {
            long num1 = scanner.nextLong();
            long num2 = scanner.nextLong();         
            // If both numbers are 0, exit the loop
            if (num1 == 0 && num2 == 0) {
                break;
            }          
            int carryCount = 0; // Initialize the count of carry operations
            long carry = 0; // Initialize the carry value           
            // Process digits from right to left until both numbers have no digits left
            while (num1 > 0 || num2 > 0) {
                long sum = (num1 % 10) + (num2 % 10) + carry;
                carry = sum / 10; // Update carry
                if (carry > 0) {
                    carryCount++; // Increment carry count if there's a carry
                }
                num1 /= 10; // Move to the next digit
                num2 /= 10; // Move to the next digit
            }           
            // Output the result based on the number of carry operations
            if (carryCount == 0) {
                System.out.println("No carry operation.");
            } else if (carryCount == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println(carryCount + " carry operations.");
            }
        }       
        scanner.close();
    }
}



