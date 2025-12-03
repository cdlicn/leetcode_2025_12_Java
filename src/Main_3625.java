import java.util.HashMap;
import java.util.Map;

// TODO 3625. 统计梯形的数目 II
public class Main_3625 {
    public int countTrapezoids(int[][] points) {
        Map<Double, Map<Double, Integer>> cnt = new HashMap<>(); // 斜率 -> 截距 -> 个数
        Map<Integer, Map<Double, Integer>> cnt2 = new HashMap<>(); // 中点 -> 斜率 -> 个数

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < i; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dy = y - y2;
                int dx = x - x2;
                double k = dx != 0 ? 1.0 * dy / dx : Double.MAX_VALUE;
                double b = dx != 0 ? 1.0 * (y * dx - x * dy) / dx : x;

                // 归一化 -0.0 为 0.0
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }

                // 按照斜率和截距分组 cnt[k][b]++
                cnt.computeIfAbsent(k, key -> new HashMap<>()).merge(b, 1, Integer::sum);

                int mid = (x + x2 + 2000) * 10000 + (y + y2 + 2000); // 把二维坐标压缩成一个 int
                // 按照中点和斜率分组 cnt2[mid][k]++
                cnt2.computeIfAbsent(mid, key -> new HashMap<>()).merge(k, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Double, Integer> m : cnt.values()) {
            int s = 0;
            for (int c : m.values()) {
                ans += s * c;
                s += c;
            }
        }

        for (Map<Double, Integer> m : cnt2.values()) {
            int s = 0;
            for (int c : m.values()) {
                ans -= s * c; // 平行四边形会统计两次，减去多统计的一次
                s += c;
            }
        }

        return ans;
    }
}
