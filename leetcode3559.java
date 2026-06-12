class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int LOG = 17;

    private int[][] up;
    private int[] depth;
    private List<Integer>[] graph;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        up = new int[LOG][n + 1];
        depth = new int[n + 1];

        for (int i = 0; i < LOG; i++) {
            Arrays.fill(up[i], -1);
        }

        dfs(1, -1);

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                if (up[k - 1][v] != -1) {
                    up[k][v] = up[k - 1][up[k - 1][v]];
                }
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int lcaNode = lca(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[lcaNode];

            ans[i] = modPow(2, dist - 1);
        }

        return ans;
    }

    private void dfs(int node, int parent) {
        up[0][node] = parent;

        for (int next : graph[node]) {
            if (next == parent) continue;

            depth[next] = depth[node] + 1;
            dfs(next, node);
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != -1 && depth[up[k][u]] >= depth[v]) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != -1 && up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    private int modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int) result;
    }
}
