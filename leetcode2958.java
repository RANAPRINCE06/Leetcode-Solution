class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> freq=new HashMap<>();
        int le=0;
        int ml=0;
        for(int i=0;i<nums.length;i++){
            freq.merge(nums[i],1,Integer::sum);
            while(freq.get(nums[i])>k){
                freq.merge(nums[le],-1,Integer::sum);
                le++;
            }
            ml=Math.max(ml,i-le+1);
        }
        return ml;
    }
}
