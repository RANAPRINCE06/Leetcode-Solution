class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;

        for (int i = 0; i < m; i++) {
            int shift = (i % 2 == 0) ? k : n - k;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + shift) % n]) return false;
            }
        }
        return true;
    }
}
