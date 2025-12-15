public class Main_2110 {
    public long getDescentPeriods(int[] prices) {
        long n = 1;
        long res = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                n++;
            } else {
                n = 1;
            }
            res += n;
        }
        return res;
    }
}
