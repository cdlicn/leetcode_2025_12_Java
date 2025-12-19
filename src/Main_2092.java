import java.util.*;

// TODO 2092. 找出知晓秘密的所有专家
public class Main_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 按照 time 从小到大排序
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        // 一开始 0 和 firstPerson 都知道秘密
        Set<Integer> haveSecret = new HashSet<>();
        haveSecret.add(0);
        haveSecret.add(firstPerson);

        // 分组循环
        int m = meetings.length;
        for (int i = 0; i < m; ) {
            // 在同一时间发生的会议，建图
            Map<Integer, List<Integer>> g = new HashMap<>();
            int time = meetings[i][2];
            for (; i < m && meetings[i][2] == time; i++) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                g.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            // 每个连通块只要有一个人知道秘密，那么整个连通块的人都知道秘密
            Set<Integer> vis = new HashSet<>(); // 避免重复访问节点
            for (int x : g.keySet()) {
                // 从知道秘密的专家出发，DFS 标记其余专家
                if (haveSecret.contains(x) && !vis.contains(x)) {
                    dfs(x, g, vis, haveSecret);
                }
            }
        }

        // 可以按任何顺序返回答案
        return new ArrayList<>(haveSecret);
    }

    private void dfs(int x, Map<Integer, List<Integer>> g, Set<Integer> vis, Set<Integer> haveSecret) {
        vis.add(x);
        haveSecret.add(x);
        for (int y : g.get(x)) {
            if (!vis.contains(y)) {
                dfs(y, g, vis, haveSecret);
            }
        }
    }
}
