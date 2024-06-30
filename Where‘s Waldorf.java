import java.util.*;
class wherewald {
    static int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = scanner.nextLine().toLowerCase().toCharArray();
            }
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                String in = scanner.next().toLowerCase();
                boolean found = false;
                for (int r = 0; r < n && !found; r++) {
                    for (int c = 0; c < m && !found; c++) {
                        for (int[] dir : dirs) {
                            int x = r, y = c, cur = 0;
                            while (cur < in.length()) {
                                if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != in.charAt(cur)) break;
                                if (++cur == in.length()) found = true;
                                x += dir[0]; y += dir[1];
                            }
                            if (found) {
                                System.out.println((r + 1) + " " + (c + 1));
                                break;
                            }
                        }
                    }
                }
            }
            if (t > 0) System.out.println();
        }
    }
}


