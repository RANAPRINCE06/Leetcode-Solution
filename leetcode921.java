class Solution {
    public int minAddToMakeValid(String s) {
        int ob=0;
        int mr=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                ob++;
            }else{
                if(ob>0){
                    ob--;
                }else{
                    mr++;
                }
            }
        }
        return mr+ob;
    }
}
