class Solution {
    public int findPeakElement(int[] nums) {
        int l=1;
        int ans=0;
        int r=nums.length-2;
        if(nums.length==1){
            return 0;
        }
        // if(nums[0]>)
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
                return mid;
                // break;
            }
            else if(nums[mid]>nums[mid-1]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(nums[0]>nums[1] && nums[nums.length-1]<nums[nums.length-2]){
            return 0;
        }
        else if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        return ans;
    }
}