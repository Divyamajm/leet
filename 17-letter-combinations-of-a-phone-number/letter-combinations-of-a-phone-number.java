class Solution {
    public void helper(String[] phone,String digits,int ind,List<String>result,StringBuilder sb){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        int x=digits.charAt(ind)-'0';
        String ans=phone[x];
        for(int i=0;i<ans.length();i++){
            sb.append(ans.charAt(i));
            helper(phone,digits,ind+1,result,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] phone={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        helper(phone,digits,0,result,sb);
        return result;
    }
}