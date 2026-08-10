class Solution {
    static final int MX=100000;
    static final boolean[] dp=new boolean[MX+1];
    static{
        for(int i=0;i<=MX;i++){
            if(dp[i]) continue;
            for(int j=1;j*j<=MX-i;j++){
                dp[i+j*j]=true;
            }
        }
    }
    public boolean winnerSquareGame(int n) {
        return dp[n];
    }
}
