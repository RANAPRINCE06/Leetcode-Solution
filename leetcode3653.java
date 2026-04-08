class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        int n = nums.length;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int i = l; i <= r; i += k) {
                arr[i] = (arr[i] * v) % MOD;
            }
        }

        int xor = 0;
        for (long x : arr) {
            xor ^= (int)x;
        }
        return xor;
    }
}
