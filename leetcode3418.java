class Solution {
    int[][] grid;
    int m, n;
    Integer[][][] dp;

    public int maximumAmount(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][3];
        return dfs(0, 0, 0);
    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (grid[i][j] < 0 && k < 2) {
                return Math.max(0, grid[i][j]);
            }
            return grid[i][j];
        }

        if (dp[i][j][k] != null) return dp[i][j][k];

        int val = grid[i][j];

        int best = Math.max(
            dfs(i + 1, j, k),
            dfs(i, j + 1, k)
        );

        int res = Integer.MIN_VALUE;

        if (best != Integer.MIN_VALUE) {
            res = val + best;
        }

        if (val < 0 && k < 2) {
            int bestSkip = Math.max(
                dfs(i + 1, j, k + 1),
                dfs(i, j + 1, k + 1)
            );
            if (bestSkip != Integer.MIN_VALUE) {
                res = Math.max(res, bestSkip);
            }
        }

        return dp[i][j][k] = res;
    }
}
