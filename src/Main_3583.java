import java.util.HashMap;
import java.util.Map;

public class Main_3583 {

    int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> preMap = new HashMap<>();
        Map<Integer, Integer> backMap = new HashMap<>();
        for (int num : nums) {
            backMap.put(num, backMap.getOrDefault(num, 0) + 1);
        }
        long res = 0;
        for (int num : nums) {
            backMap.put(num, backMap.getOrDefault(num, 0) - 1);
            int x = num * 2;
            res = (res + (1L * preMap.getOrDefault(x, 0) * backMap.getOrDefault(x, 0))) % MOD;
            preMap.put(num, preMap.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}
