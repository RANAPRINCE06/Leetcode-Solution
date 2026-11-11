class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans;

        if ((long) cost1 + cost2 <= costBoth) {
            ans = (long) need1 * cost1
                   + (long) need2 * cost2;
        } else {
            int common = Math.min(need1, need2);

            ans = (long) common * costBoth;

            int remaining1 = need1 - common;
            int remaining2 = need2 - common;

            ans += (long) remaining1 * Math.min(cost1, costBoth);
            ans += (long) remaining2 * Math.min(cost2, costBoth);
        }

        return ans;
    }
}
