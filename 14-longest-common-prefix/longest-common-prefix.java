class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);
        char[] s1=strs[0].toCharArray();
        char[] s2=strs[strs.length-1].toCharArray();
        int min=Math.min(s1.length,s2.length);
        for(int i=0;i<min;i++){
            if(s1[i]!=s2[i]){
                return sb.toString();
            }
            sb.append(s1[i]);
        }
        return sb.toString();
    }
}