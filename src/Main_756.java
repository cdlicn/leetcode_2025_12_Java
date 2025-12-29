import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO 756. 金字塔转换矩阵
public class Main_756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // 三角形底部两个字母 -> [三角形顶部字母]
        List<Character>[][] groups = new ArrayList[6][6];
        for (List<Character>[] row : groups) {
            Arrays.setAll(row, o -> new ArrayList<>());
        }
        for (String S : allowed) {
            char[] s = S.toCharArray();
            groups[s[0] - 'A'][s[1] - 'A'].add(s[2]);
        }

        int n = bottom.length();
        char[][] pyramid = new char[n][];
        for (int i = 0; i < n - 1; i++) {
            pyramid[i] = new char[i + 1];
        }
        pyramid[n - 1] = bottom.toCharArray();

        // 从倒数第二行开始填
        return dfs(n - 2, 0, pyramid, groups);
    }

    // 现在准备填 (i, j) 这个格子
    // 返回继续填能否填完所有格子（从下往上填，每行从左到右填）
    private boolean dfs(int i, int j, char[][] pyramid, List<Character>[][] groups) {
        if (i < 0) { // 所有格子都已填完
            return true;
        }

        if (j == i + 1) { // i 行已填完
            return dfs(i - 1, 0, pyramid, groups); // 开始填 i-1 行
        }

        // 枚举 (i, j) 填什么字母
        // 这取决于 (i+1, j) 和 (i+1, j+1) 填的字母
        for (char top : groups[pyramid[i + 1][j] - 'A'][pyramid[i + 1][j + 1] - 'A']) {
            pyramid[i][j] = top;
            if (dfs(i, j + 1, pyramid, groups)) {
                return true;
            }
        }
        return false;
    }
}
