import java.util.Arrays;

public class Main_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        int n = happiness.length;
        for (int i = n - 1; i >= n - k && n - i - 1 < k; i--) {
            int x = n - i - 1;
            if (happiness[i] <= x) {
                break;
            }
            res += happiness[i] - x;
        }
        return res;
    }
}
