class Solution {
    public int maximumLengthSubstring(String s) {
        int res=0;
        int[] fq=new int[26];
        for(int i=0,j=0;j<s.length();j++){
            fq[(s.charAt(j) & 31)-1]++;
            while(fq[(s.charAt(j) & 31)-1]>2){
               fq[(s.charAt(i++) & 31)-1]--; 
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}
