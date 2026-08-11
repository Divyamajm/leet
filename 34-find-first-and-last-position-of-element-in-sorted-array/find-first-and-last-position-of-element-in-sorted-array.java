class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ans1=-1;
        int ans2=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                // found=1;
                r=mid-1;
                ans1=mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                // found=1;
                l=mid+1;
                ans2=mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return new int[]{ans1,ans2};
    }
}