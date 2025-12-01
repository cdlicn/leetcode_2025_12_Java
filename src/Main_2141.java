// TODO 2141. 同时运行 N 台电脑的最长时间
public class Main_2141 {
    public long maxRunTime(int n, int[] batteries) {
        long tot = 0;
        for (int b : batteries) {
            tot += b;
        }

        long l = 0;
        long r = tot / n + 1;
        while (l + 1 < r) {
            long x = l + (r - l) / 2;
            long sum = 0;
            for (int b : batteries) {
                sum += Math.min(b, x);
            }
            if (n * x <= sum) {
                l = x;
            } else {
                r = x;
            }
        }
        return l;
    }
}
