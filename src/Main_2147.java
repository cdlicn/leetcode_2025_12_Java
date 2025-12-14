// TODO 2147. 分隔长廊的方案数
public class Main_2147 {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        long ans = 1;
        int cntS = 0;
        int lastS = 0;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                cntS++;
                // 对于第 3,5,7,... 个座位，可以在其到其左侧最近座位之间的任意空隙放置屏风
                if (cntS >= 3 && cntS % 2 > 0) {
                    ans = ans * (i - lastS) % MOD;
                }
                lastS = i; // 记录上一个座位的位置
            }
        }

        if (cntS == 0 || cntS % 2 > 0) { // 座位个数不能为 0 或奇数
            return 0;
        }
        return (int) ans;
    }
}
