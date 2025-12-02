import java.util.HashMap;
import java.util.Map;

public class Main_3623 {
    private static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }
        long res = 0, s = 0;
        for (Integer val : map.values()) {
            long tmp = (long) val * (val - 1) / 2;
            res += s * tmp;
            s += tmp;
        }
        return (int) (res % MOD);
    }
}
