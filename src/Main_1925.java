public class Main_1925 {
    public int countTriples(int n) {
        int res = 0;
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < a && a * a + b * b <= n * n; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (c * c == a * a + b * b) {
                    res += 2;
                }
            }
        }
        return res;
    }
}
