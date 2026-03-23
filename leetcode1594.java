class Solution {
    public int maxProductPath(int[][] grid) {
         int m = grid.length, n = grid[0].length;
        long[] max = new long[n], min = new long[n];
        
        max[0] = min[0] = grid[0][0];
        
        for (int j = 1; j < n; j++) {
            max[j] = min[j] = max[j - 1] * grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            max[0] = min[0] = max[0] * grid[i][0];
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                long a = max[j] * val, b = min[j] * val;
                long c = max[j - 1] * val, d = min[j - 1] * val;
                max[j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        
        long res = max[n - 1];
        return res < 0 ? -1 : (int)(res % 1_000_000_007);
    }
}
