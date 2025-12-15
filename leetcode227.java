class Solution {
    public int calculate(String s) {
     int num=0,last=0,result=0;
     char op='+';
     for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(Character.isDigit(c)){
            num=num*10+(c-'0');  
        }
        if((!Character.isDigit(c) && c != ' ') || i==s.length()-1){
            if(op=='+'){
                result+=last;
                last=num;
            }else if(op=='-'){
                result+=last;
                last=-num;
            }else if(op=='*'){
                last=last*num;
            }else if(op=='/'){
                last=last/num;
            }
            op=c;
            num=0;
        }
     }   
     return result+last;
    }
}