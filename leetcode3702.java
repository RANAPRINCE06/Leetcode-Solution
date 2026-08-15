class Solution {
    public int longestSubsequence(int[] nums) {
        int to=0,n=nums.length;
        boolean noz=false;
        for(int x : nums){
            noz |= x > 0;
            to ^= x;
        }
        if(!noz) return 0;
        return to == 0 ? n - 1 : n; 
    }
}
