class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] c=new int[26];
        for(char ch : text.toCharArray()){
            c[ch-'a']++;
        }
        return Math.min(Math.min(c['b'-'a'],c['a'-'a']),Math.min(Math.min(c['l'-'a']/2,c['o'-'a']/2),c['n'-'a']));
    }
}
