import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        String[] list = new String[n];
        Arrays.fill(list, "");
        int res = 0;
        for (int j = 0; j < m; j++) {
            boolean flag = false;
            for (int i = 0; i < n - 1; i++) {
                if ((list[i] + strs[i].charAt(j)).compareTo(list[i + 1] + strs[i + 1].charAt(j)) > 0) {
                    res++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 0; i < n; i++) {
                    list[i] += strs[i].charAt(j);
                }
            }
        }
        return res;
    }
}
