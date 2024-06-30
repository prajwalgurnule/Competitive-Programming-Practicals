import java.util.Scanner;
import java.util.Arrays;

class shoemaker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int N = scanner.nextInt();
            int[][] data = new int[N][3];
            for (int n = 0; n < N; n++) {
                data[n][0] = n + 1;
                data[n][1] = scanner.nextInt();
                data[n][2] = scanner.nextInt();
            }

            Arrays.sort(data, (a, b) -> {
                int d = a[1] * b[2] - b[1] * a[2];
                if (d == 0) return a[0] - b[0];
                return d;
            });

            StringBuilder sb = new StringBuilder();
            for (int[] ans : data) {
                sb.append(ans[0]).append(' ');
            }
            sb.setLength(sb.length() - 1);
            if (testCase > 0) System.out.println();
            System.out.println(sb.toString());
        }
    }
}


