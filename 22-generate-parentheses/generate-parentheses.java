class Solution {
    public void helper(int n,List<String>result,StringBuilder sb,int o,int c){
        if(sb.length()==n*2){
            result.add(sb.toString());
            return;
        }
        if(o<n){
            sb.append("(");
            helper(n,result,sb,o+1,c);
            sb.deleteCharAt(sb.length()-1);
        }
        if(o>c){
            sb.append(")");
            helper(n,result,sb,o,c+1);
            sb.deleteCharAt(sb.length()-1);
            // c--;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList();
        helper(n,result,new StringBuilder(),0,0);
        return result;
    }
}