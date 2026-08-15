class Solution {
    public String removeOuterParentheses(String s) {
        int depth=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                if(depth>0){
                    sb.append(c);
                }
                depth++;
            }
            else if(c==')'){
                depth--;
                if(depth>0){
                    sb.append(c);
                }
            }
        }
        String s1=sb.toString();
        return s1;
    }
}