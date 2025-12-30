import java.util.Set;

public class Main_840 {

    boolean judge(int... nums) {
        // 0 1 2
        // 3 4 5
        // 6 7 8
        boolean[] visited = new boolean[10];
        for (int num : nums) {
            if (num > 9 || num < 1) {
                return false;
            }
            if (visited[num]) {
                return false;
            }
            visited[num] = true;
        }
        return nums[0] + nums[1] + nums[2] == 15 &&
                nums[3] + nums[4] + nums[5] == 15 &&
                nums[6] + nums[7] + nums[8] == 15 &&
                nums[0] + nums[3] + nums[6] == 15 &&
                nums[1] + nums[4] + nums[7] == 15 &&
                nums[2] + nums[5] + nums[8] == 15 &&
                nums[0] + nums[4] + nums[8] == 15 &&
                nums[2] + nums[4] + nums[6] == 15;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        if (m < 3 || n < 3) {
            return 0;
        }
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (judge(grid[i][j], grid[i][j + 1], grid[i][j + 2], grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2], grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    res++;
                }
            }
        }
        return res;
    }
}
