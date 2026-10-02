class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=n-m;i++){
            for(int j=i;j<i+m;j++){
                sb.append(haystack.charAt(j));
                String s=sb.toString();
                if(s.equals(needle)){
                    return i;
                }
            }
            sb.setLength(0);
        }return -1;
    }
}