class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=1;
        int r=nums.length-2;
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-2]!=nums[n-1]){
            return nums[n-1];
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid-1]!=nums[mid]&&nums[mid+1]!=nums[mid]){
                return nums[mid];
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            else{
                if(nums[mid]==nums[mid-1]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }return -1;
    }
}