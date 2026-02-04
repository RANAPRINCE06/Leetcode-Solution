// public class leetcode3640 {
    
// }
class Solution {
    public long maxSumTrionic(int[] nums) {

        int n = nums.length;
        long res = -1L * (long)1e16;

        for (int i = 1; i < n - 2; i++) {

            int a = i, b = i;
            long net = nums[a];

            while (b + 1 < n && nums[b + 1] < nums[b]) {
                net += nums[b + 1];
                b++;
            }

            if (a == b) continue;

            int c = b;

            long left = 0, right = 0;
            long lx = Long.MIN_VALUE, rx = Long.MIN_VALUE;

            while (a - 1 >= 0 && nums[a - 1] < nums[a]) {
                left += nums[a - 1];
                lx = Math.max(lx, left);
                a--;
            }

            if (a == i) continue;

            while (b + 1 < n && nums[b + 1] > nums[b]) {
                right += nums[b + 1];
                rx = Math.max(rx, right);
                b++;
            }

            if (b == c) continue;

            i = b - 1;
            res = Math.max(res, lx + net + rx);
        }

        return res;
    }
}