class Solution {
    public long binary(int[] piles,int mid){
        long total=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            total+=Math.ceil((double)piles[i]/mid);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        int l=0;
        int ans=-1;
        int r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(binary(piles,mid)<=h){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}