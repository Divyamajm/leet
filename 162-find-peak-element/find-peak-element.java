class Solution {
    public int findPeakElement(int[] nums) {
        // Handle edges first
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0; // Check left boundary independently
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1; // Check right boundary independently
        
        // Binary search for the inner elements
        int l = 1;
        int r = nums.length - 2;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid] > nums[mid-1]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        return -1; // Fallback
    }
}