class Solution {
public:
    int numberOfWays(string s) {
        int cnt = 0, mod = 1e9+7;
        for(auto it:s) cnt += (it == 'S');
        if((cnt&1) || (!cnt)) return 0;

        while(!s.empty() && s.back() == 'P') s.pop_back();
        int i = 0, n = s.size();;
        while(i < n && s[i] == 'P') i++;

        long long prod = 1;
        cnt = 0;
        
        while(i < n) {
            cnt += s[i] == 'S';
            if(cnt%2 == 0) {
                int j = i+1;

                while(j < n && s[j] == 'P') j++;
                
                prod *= (j-i);
                prod %= mod;
                i = j;
            }
            else i++;
        }
        return (int)prod;
    }
};