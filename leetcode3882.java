class Solution {
    public int minCost(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       boolean[][] dp=new boolean[n][1024];
        dp[0][grid[0][0]]=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                boolean[] curr=new boolean[1024];
                int val=grid[i][j];
                for(int x=0;x<1024;x++){
                    boolean fromTop=(i>0 && dp[j][x]);
                    boolean fromLeft=(j>0 && dp[j-1][x]);
                    if(fromTop || fromLeft){
                        curr[x^val]=true;
                    }
                }
                dp[j] =curr;
            }
        }
        for(int x=0;x<1024;x++){
            if(dp[n-1][x]) return x;
        }
        return -1;
    }
}
