class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        long long maxi =0;
        int n = prices.size();
        vector<long long > prefix(n+1,0);
        vector<long long > prefixProfit(n+1,0);
        for(int i=0;i<n;i++){
            maxi += prices[i]*strategy[i];
            prefix[i+1]=prices[i];
            prefix[i+1]+=prefix[i];
            prefixProfit[i+1] = prices[i]*strategy[i];
            prefixProfit[i+1]+=prefixProfit[i];
        }
        for(int i=k;i<=n;i++){
            long long ans =  prefixProfit[n] -(prefixProfit[i]-prefixProfit[i-k]);
            ans+=(prefix[i]-prefix[i-k/2]);
            maxi = max(maxi,ans);
        }
        return maxi;
    }
};