import java.util.Scanner;

class lcd {
    public static void printTable(char[][] table, char c, int s, int x) {
        int row, cul;
        for (cul = x; cul <= x + s + 1; cul++)
            for (row = 0; row <= 2 * s + 2; row++)
                if (cul == x || cul == x + s + 1)
                    if ((row >= 1 && row <= s) || (row >= s + 2 && row <= 2 * s + 1))
                        table[row][cul] = '|';
                    else
                        table[row][cul] = ' ';
                else if ((row >= 1 && row <= s) || (row >= s + 2 && row <= 2 * s + 1))
                    table[row][cul] = ' ';
                else
                    table[row][cul] = '-';
        switch (c) {
            case '0':
                for (cul = x + 1; cul <= x + s; cul++)
                    table[s + 1][cul] = ' ';
                break;
            case '1':
                for (row = 1; row <= 2 * s + 2; row++)
                    table[row][x] = ' ';
                for (cul = x + 1; cul <= x + s; cul++)
                    table[0][cul] = table[s + 1][cul] = table[2 * s + 2][cul] = ' ';
                break;
            case '2':
                for (row = 1; row <= s; row++)
                    table[row][x] = ' ';
                for (row = s + 2; row <= 2 * s + 1; row++)
                    table[row][x + s + 1] = ' ';
                break;
            case '3':
                for (row = 1; row <= 2 * s + 1; row++)
                    table[row][x] = ' ';
                break;
            case '4':
                for (cul = x; cul <= x + s + 1; cul++)
                    table[0][cul] = table[2 * s + 2][cul] = ' ';
                for (row = s + 2; row <= 2 * s + 1; row++)
                    table[row][x] = ' ';
                break;
            case '5':
                for (row = 1; row <= s; row++)
                    table[row][x + s + 1] = ' ';
                for (row = s + 2; row <= 2 * s + 1; row++)
                    table[row][x] = ' ';
                break;
            case '6':
                for (row = 1; row <= s; row++)
                    table[row][x + s + 1] = ' ';
                break;
            case '7':
                for (row = 1; row <= 2 * s + 1; row++)
                    table[row][x] = ' ';
                for (cul = x + 1; cul <= x + s; cul++)
                    table[s + 1][cul] = table[2 * s + 2][cul] = ' ';
                break;
            case '8':
                break;
            case '9':
                for (row = s + 2; row <= 2 * s + 1; row++)
                    table[row][x] = ' ';
                break;
        }
        for (row = 0; row <= 2 * s + 2; row++)
            table[row][x + s + 2] = ' ';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int s = scanner.nextInt();
            String str = scanner.next();
            if (s == 0 && str.equals("0"))
                break;
            char[][] table = new char[30][1000];
            int row, cul = 0;
            for (int i = 0; i < str.length(); i++) {
                printTable(table, str.charAt(i), s, cul);
                cul += s + 3;
            }
            for (row = 0, cul--; row <= 2 * s + 2; row++)
                table[row][cul] = '\0';
            for (int i = 0; i <= 2 * s + 2; i++)
                System.out.println(new String(table[i]));
            System.out.println();
        }
    }
}


