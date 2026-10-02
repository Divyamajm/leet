class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first=strs[0];
        String second=strs[strs.length-1];
        int n=Math.min(first.length(),second.length());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(first.charAt(i)!=second.charAt(i)){
                break;
            }
            else{
                sb.append(first.charAt(i));
            }
        }return sb.toString();
    }
}