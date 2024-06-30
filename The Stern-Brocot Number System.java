import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            if (a == 1 && b == 1) break;

            int aLeft = 0, aRight = 1, bLeft = 1, bRight = 0;
            while (true) {
                int x = aLeft + aRight, y = bLeft + bRight;

                int val = a * y - x * b;
                if (val == 0) break;
                if (val < 0) { // Go left
                    aRight = x;
                    bRight = y;
                    sb.append("L");
                } else { // Go right
                    aLeft = x;
                    bLeft = y;
                    sb.append("R");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

