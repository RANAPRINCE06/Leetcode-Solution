class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        priority_queue<int> q;
        for(int i: happiness){
            q.push(i);
        }

        int dec =0;
        long long ans =0;
        while(dec<k){
            ans+=max((q.top()-dec),0);
            q.pop();
            dec++;
        }

        return ans;
    }
};