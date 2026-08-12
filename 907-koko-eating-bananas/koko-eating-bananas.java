class Solution {
    private long helper(int mid,int[] piles){
        long total=0;
        for(int i=0;i<piles.length;i++){
            total+=(long)Math.ceil((double)piles[i]/mid);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int total=0;
        // int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i],max);
            // min=Math.min(min,piles[i]);
        }
        int ans=Integer.MAX_VALUE;;
        int l=1;
        int r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            long time=helper(mid,piles);
            if(time<=h){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}