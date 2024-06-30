import java.util.Scanner;

class Ones {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int numberOfOnes = 1;
            int tmp = 1;
            int number = input.nextInt();
            while (tmp != 0) {
                if (number > tmp) {
                    numberOfOnes++;
                }
                tmp = (tmp * 10 + 1) % number;
            }
            System.out.println(numberOfOnes);
        }
        input.close();
    }
}

