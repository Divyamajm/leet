class Solution {
    public int binary(int[] nums,int mid){
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=Math.ceil((double)nums[i]/mid);
        }
        return total;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        // int total=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int l=1;
        int r=max;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(binary(nums,mid)<=threshold){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}