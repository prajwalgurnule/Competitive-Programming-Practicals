import java.util.Arrays;
import java.util.Scanner;

class vito_family{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int arrayLength = scanner.nextInt();
            int[] values = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                values[i] = scanner.nextInt();
            }
            Arrays.sort(values);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < arrayLength; i++) {
                int diff = 0;
                for (int value : values) {
                    diff += Math.abs(value - values[i]);
                }
                minDiff = Math.min(diff, minDiff);
            }
            System.out.println(minDiff);
        }
        scanner.close();
    }
}

