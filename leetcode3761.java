class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int idx = 0; idx < nums.length; idx++) {
            int val = nums[idx];

            if (seen.containsKey(val)) {
                ans = Math.min(ans, idx - seen.get(val));
            }

            int rev = reverse(val);
            seen.put(rev, idx);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int num) {
        int res = 0;

        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        return res;
    }
}
