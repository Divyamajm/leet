class Solution {
    private int helper(int mid,int[] weights){
        int count=1;
        int total=0;
        for(int i=0;i<weights.length;i++){
            total+=weights[i];
            if(total>mid){
                total=weights[i];
                count++;
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int total=0;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            total+=weights[i];
            min=Math.max(min,weights[i]);
        }
        int l=min;
        int r=total;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int x=helper(mid,weights);
            if(x<=days){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}