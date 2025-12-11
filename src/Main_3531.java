import java.util.Arrays;

public class Main_3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] xMin = new int[n + 1];
        int[] xMax = new int[n + 1];
        int[] yMin = new int[n + 1];
        int[] yMax = new int[n + 1];
        Arrays.fill(xMin, Integer.MAX_VALUE);
        Arrays.fill(yMin, Integer.MAX_VALUE);
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            xMin[x] = Math.min(xMin[x], y);
            xMax[x] = Math.max(xMax[x], y);
            yMin[y] = Math.min(yMin[y], x);
            yMax[y] = Math.max(yMax[y], x);
        }
        int res = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (xMin[x] < y && y < xMax[x] && yMin[y] < x && x < yMax[y]) {
                res++;
            }
        }
        return res;
    }
}
