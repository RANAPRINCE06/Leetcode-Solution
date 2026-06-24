class Solution {
    static final long MOD = 1_000_000_007L;
    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
    private long[][] power(long[][] base, long exp) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) {
            return m;
        }
        long[][] up = new long[m][m];
        long[][] down = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                up[i][j] = 1;
            }
            for (int j = i + 1; j < m; j++) {
                down[i][j] = 1;
            }
        }
        long[][] trans = multiply(up, down);
        long[][] mat = power(trans, (n - 1) / 2);
        if ((n - 1) % 2 == 1) {
            mat = multiply(mat, up);
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans = (ans + mat[i][j]) % MOD;
            }
        }
        ans = (ans * 2) % MOD;
        return (int) ans;
    }
}
