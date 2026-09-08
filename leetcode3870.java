class Solution {
    public int countCommas(int n) {
        int total=0;
        int th=1000;
        while(th<=n){
            total+=(n-th+1);
            th*=1000;
        }
        return total;
    }
}
