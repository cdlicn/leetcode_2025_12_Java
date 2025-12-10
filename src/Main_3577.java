public class Main_3577 {

    int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int mn = complexity[0];
        for (int i = 1; i < complexity.length; i++) {
            if (mn >= complexity[i]) {
                return 0;
            }
        }
        long res = 1;
        for (int i = 1; i <= complexity.length - 1; i++) {
            res = (res * i) % MOD;
        }
        return (int) res;
    }
}
