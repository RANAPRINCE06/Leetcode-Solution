// public class leetcode1895 {
    
// }
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; i + k <= m && j + k <= n; k++) {
                    int target = row[i][j + k] - row[i][j];
                    boolean ok = true;

                    for (int r = i; r < i + k && ok; r++) {
                        if (row[r][j + k] - row[r][j] != target) ok = false;
                    }

                    for (int c = j; c < j + k && ok; c++) {
                        if (col[i + k][c] - col[i][c] != target) ok = false;
                    }

                    int d1 = 0, d2 = 0;
                    for (int t = 0; t < k; t++) {
                        d1 += grid[i + t][j + t];
                        d2 += grid[i + t][j + k - 1 - t];
                    }

                    if (d1 != target || d2 != target) ok = false;

                    if (ok) ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }
}
