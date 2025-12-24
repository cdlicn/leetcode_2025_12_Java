import java.util.Arrays;

public class Main_3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int res = 0;
        int r = capacity.length - 1;
        while (sum > 0) {
            sum -= capacity[r--];
            res++;
        }
        return res;
    }
}
