import java.util.Arrays;

// TODO 3573. 买卖股票的最佳时机 V
public class Main_3573 {

    private int[] prices;
    private long[][][] memo;

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        int n = prices.length;
        memo = new long[n][k + 1][3];
        for (long[][] mat : memo) {
            for (long[] row : mat) {
                Arrays.fill(row, Long.MIN_VALUE); // MIN_VALUE 表示还没有计算过
            }
        }
        return dfs(n - 1, k, 0);
    }

    // 在 [0,i] 中完成至多 j 笔交易，第 i 天【结束时】的状态为 endState 的情况下的最大收益
    // 0=未持有股票，1=持有股票，2=做空中
    private long dfs(int i, int j, int endState) {
        if (j < 0) {
            return Long.MIN_VALUE / 2; // 除 2 防止溢出
        }
        if (i < 0) {
            return endState > 0 ? Long.MIN_VALUE / 2 : 0;
        }
        if (memo[i][j][endState] != Long.MIN_VALUE) { // 之前计算过
            return memo[i][j][endState];
        }
        int p = prices[i];
        if (endState == 0) {
            return memo[i][j][endState] = Math.max(dfs(i - 1, j, 0), Math.max(dfs(i - 1, j, 1) + p, dfs(i - 1, j, 2) - p));
        }
        if (endState == 1) {
            return memo[i][j][endState] = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - p);
        }
        return memo[i][j][endState] = Math.max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + p);
    }

}
