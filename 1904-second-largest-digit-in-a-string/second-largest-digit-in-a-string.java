class Solution {
    public int secondHighest(String s) {
        int n=s.length();
        int max1=-1;
        int max2=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9){
                if(s.charAt(i)-'0'>max1){
                    max2=max1;
                    max1=s.charAt(i)-'0';
                }
                else if(s.charAt(i)-'0'>max2&&s.charAt(i)-'0'!=max1){
                    max2=s.charAt(i)-'0';
                }
            }
        }
        return max2;
    }
}