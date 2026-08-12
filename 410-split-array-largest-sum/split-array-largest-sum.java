class Solution {
    private int helper(int mid,int[]nums){
        int count=1;
        int total=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            if(total>mid){
                total=nums[i];
                count++;
            }
        }return count;
    }
    public int splitArray(int[] nums, int k) {
        if(k>nums.length){
            return -1;
        }
        int total=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int l=max;
        int r=total;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int x=helper(mid,nums);
            if(x<=k){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}