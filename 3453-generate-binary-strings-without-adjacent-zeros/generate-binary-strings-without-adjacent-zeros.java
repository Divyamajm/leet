class Solution {
    public void helper(int n,List<String>result,StringBuilder current){
        if(current.length()==n){
            result.add(new String(current.toString()));
            return;
        }
        current.append("1");
        helper(n,result,current);
        current.deleteCharAt(current.length()-1);
        if(current.length()==0||current.charAt(current.length()-1)=='1'){
            current.append("0");
            helper(n,result,current);
            current.deleteCharAt(current.length()-1);
        }
    }
    public List<String> validStrings(int n) {
        List<String>result=new ArrayList();
        helper(n,result,new StringBuilder());
        return result;
    }
}