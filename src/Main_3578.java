import java.util.ArrayDeque;
import java.util.Deque;

// TODO 3578. 统计极差最大为 K 的分割方式数
public class Main_3578 {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        Deque<Integer> minQ = new ArrayDeque<>(); // 更快的写法见【Java 数组】
        Deque<Integer> maxQ = new ArrayDeque<>();
        int[] f = new int[n + 1];
        f[0] = 1;
        long sumF = 0; // 窗口中的 f[i] 之和
        int left = 0;

        for (int i = 0; i < n; i++) {
            // 1. 入
            sumF += f[i];

            int x = nums[i];
            while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(i);

            while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);

            // 2. 出
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                sumF -= f[left];
                left++;
                if (minQ.peekFirst() < left) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() < left) {
                    maxQ.pollFirst();
                }
            }

            // 3. 更新答案
            f[i + 1] = (int) (sumF % MOD);
        }

        return f[n];
    }
}
