class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int p=s.length();
        for(int m=k;m<=p;m++){
            String ans="";
            for(int i=m;i<=p;i++){
                String t=s.substring(i-m,i);
                int cnt=0;
                for(int j=0;j<t.length();j++){
                    cnt+=t.charAt(j)-'0';
                }
                if((ans.isEmpty() || t.compareTo(ans)<0) && cnt==k){
                    ans=t;
                }
            }
            if(!ans.isEmpty()){
                return ans;
            }
        }
        return "";
    }
}
