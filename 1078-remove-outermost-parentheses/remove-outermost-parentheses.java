class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int depth=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                if(depth>0){
                    sb.append(c);
                }
                depth++;
            }
            else{
                depth--;
                if(depth>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}