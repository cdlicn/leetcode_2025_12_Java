public class Main_1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    if (j == 0) {
                        return res + (m - i) * n;
                    }
                    res += n - j;
                    break;
                }
            }
        }
        return res;
    }
}
