class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int ans=nums.length;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target>nums[mid]){
                l=mid+1;
                // ans=mid;
            }
            else{
                r=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}