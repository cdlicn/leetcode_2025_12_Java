import java.util.Arrays;

public class Main_3432 {
    public int countPartitions(int[] nums) {
        int s = Arrays.stream(nums).sum();
//        int res = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int num = nums[i];
//            res += Math.abs(((s - num * 2) + 1)) % 2;
//        }
//        return res;
        return s % 2 == 0 ? nums.length - 1 : 0;
    }
}
