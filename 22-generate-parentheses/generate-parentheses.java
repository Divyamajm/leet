class Solution {
    public void back(int n,StringBuilder sb,List<String>result,int open,int close){
        if(sb.length()==n*2){
            result.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            back(n,sb,result,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open>close){
            sb.append(")");
            back(n,sb,result,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int open=0;
        int close=0;
        back(n,sb,result,open,close);
        return result;
    }
}