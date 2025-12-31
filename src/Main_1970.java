// TODO 1970. 你能穿过矩阵的最后一天
public class Main_1970 {
    class UnionFind {
        private final int[] fa; // 代表元

        UnionFind(int n) {
            // 一开始有 n 个集合 {0}, {1}, ..., {n-1}
            // 集合 i 的代表元是自己
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 返回 x 所在集合的代表元
        // 同时做路径压缩，也就是把 x 所在集合中的所有元素的 fa 都改成代表元
        public int find(int x) {
            // 如果 fa[x] == x，则表示 x 是代表元
            if (fa[x] != x) {
                fa[x] = find(fa[x]); // fa 改成代表元
            }
            return fa[x];
        }

        // 判断 x 和 y 是否在同一个集合
        public boolean isSame(int x, int y) {
            // 如果 x 的代表元和 y 的代表元相同，那么 x 和 y 就在同一个集合
            // 这就是代表元的作用：用来快速判断两个元素是否在同一个集合
            return find(x) == find(y);
        }

        // 把 from 所在集合合并到 to 所在集合中
        public void merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            fa[x] = y; // 合并集合。修改后就可以认为 from 和 to 在同一个集合了
        }
    }

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 左右上下

    public int latestDayToCross(int m, int n, int[][] cells) {
        int top = m * n;
        int bottom = m * n + 1;
        UnionFind uf = new UnionFind(m * n + 2);
        boolean[][] land = new boolean[m][n];

        for (int day = cells.length - 1; ; day--) {
            int[] cell = cells[day];
            int r = cell[0] - 1; // 改成从 0 开始的下标
            int c = cell[1] - 1;
            int v = r * n + c;
            land[r][c] = true; // 变成陆地

            if (r == 0) {
                uf.merge(v, top); // 与最上边相连
            }

            if (r == m - 1) {
                uf.merge(v, bottom); // 与最下边相连
            }

            for (int[] d : DIRS) {
                int x = r + d[0];
                int y = c + d[1];
                if (0 <= x && x < m && 0 <= y && y < n && land[x][y]) {
                    uf.merge(v, x * n + y); // 与四周的陆地相连
                }
            }

            if (uf.isSame(top, bottom)) { // 最上边和最下边连通
                return day;
            }
        }
    }
}
