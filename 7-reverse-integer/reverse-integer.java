class Solution {
    public int reverse(int x) {
        long total=0;
        long found=1;
        if(x<0){
            found=-1;
            x=-x*1;
        }
        while(x>0){
            long digit=x%10;
            total=total*10+digit;
            x=x/10;
        }
        if(total>Integer.MAX_VALUE){
            return 0;
        }
        return (int)(total*found);
    }
}