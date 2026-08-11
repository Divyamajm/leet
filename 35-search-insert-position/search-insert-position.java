class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ans=nums.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            // if(){

            // }
            if(nums[mid]>=target){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }return ans;
    }
}