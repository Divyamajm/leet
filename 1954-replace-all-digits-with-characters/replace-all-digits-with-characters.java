class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=1;i<n;i+=2){
            char c=s.charAt(i-1);
            char d=(char)(c+s.charAt(i)-'0');
            sb.append(c);
            sb.append(d);
        }
        if (n % 2 != 0) {
            sb.append(s.charAt(n - 1));
        }
        return sb.toString();
    }
}