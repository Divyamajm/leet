class Solution {
    private int helper(int mid,int[] nums){
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=(int)Math.ceil((double)nums[i]/mid);
        }
        return total;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int l=1;
        int r=max;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int x=helper(mid,nums);
            if(x<=threshold){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}