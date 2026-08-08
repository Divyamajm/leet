class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
        long total=0;
        long found=1;
        if(x<0){
            return false;
        }
        while(x>0){
            long digit=x%10;
            total=total*10+digit;
            x=x/10;
        }
        // if(total>Integer.MAX_VALUE){
        //     return false;
        // }
        return (int)(total*found)==y;
    }
}