class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Integer>s=new Stack();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int c=num.charAt(i)-'0';
            while(!s.isEmpty()&&s.peek()>c&&k>0){
                s.pop();
                k--;
            }
            s.push(c);
        }
        while(k>0){
            s.pop();
            k--;
        }
        int x=s.size();
        for(int i=0;i<x;i++){
            sb.append(s.pop());
        }
        sb.reverse();
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
    }
}