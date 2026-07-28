class Solution {
    public String smallestPalindrome(String s) {
        int p=s.length(),j=0;
        int[] fre=new int[26];
        char[] c=s.toCharArray();
        for(int i=0;i< p >>1;i++){
            fre[(c[i] & 31)-1]++;
        }
        for(int i=0;i<26;i++){
            while(fre[i]-->0){
                c[j]=(char)(97+i);
                c[p-1-j++]=(char)(97+i);
            }
        }
        return new String(c);
    }
}
