class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c1=s.charAt(i);
            char c=Character.toLowerCase(c1);
            if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9'){
                sb.append(c);
            }
        }
        String x=sb.toString();
        sb.reverse();
        String y=sb.toString();
        if(x.equals(y)){
            return true;
        }
        return false;
    }
}