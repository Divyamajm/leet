class Solution {
    public void back(int n,StringBuilder sb,List<String>result){
        if(sb.length()==n){
            result.add(sb.toString());
            return;
        }
        sb.append("1");
        back(n,sb,result);
        sb.deleteCharAt(sb.length()-1);
        if(sb.length()==0||sb.charAt(sb.length()-1)=='1'){
            sb.append("0");
            back(n,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> validStrings(int n) {
        StringBuilder sb=new StringBuilder();
        List<String>result=new ArrayList<>();
        back(n,sb,result);
        return result;
    }
}