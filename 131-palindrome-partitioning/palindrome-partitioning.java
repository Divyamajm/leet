class Solution {
    public boolean isSafe(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void helper(String s,List<List<String>>result,List<String>current,int ind){
        if(ind==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isSafe(ind,i,s)){
                current.add(s.substring(ind,i+1));
                helper(s,result,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        helper(s,result,new ArrayList<>(),0);
        return result;
    }
}