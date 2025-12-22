
// TODO 960. 删列造序 III
public class Main_960 {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int[] f = new int[m];
        int maxF = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 f[j] <= f[i]，就不用跑 O(n) 的 lessEq 了
                if (f[j] > f[i] && lessEq(strs, j, i)) {
                    f[i] = f[j];
                }
            }
            f[i]++;
            maxF = Math.max(maxF, f[i]);
        }
        return m - maxF;
    }

    // 对于每一行，j 列的字母都 <= i 列的字母？
    private boolean lessEq(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
