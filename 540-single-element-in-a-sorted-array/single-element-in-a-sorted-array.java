class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 1. Handle edge case for array of size 1
        if (nums.length == 1) {
            return nums[0];
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        // Check boundaries first to avoid bounds issues in the loop
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[r] != nums[r - 1]) {
            return nums[r];
        }
        
        l++;
        r--;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            // Found the single element (BUG 2 FIXED: return nums[mid])
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // The pair ends at mid. Elements before the pair = (mid - 1)
            else if (nums[mid] == nums[mid - 1]) {
                // BUG 3 FIXED: Check if the number of elements to the left is odd
                if ((mid - 1) % 2 != 0) {
                    r = mid - 2; // Single element is on the left
                } else {
                    l = mid + 1; // Single element is on the right
                }
            }
            
            // The pair starts at mid. Elements before the pair = mid
            else if (nums[mid] == nums[mid + 1]) {
                // BUG 3 FIXED: Check if the number of elements to the left is odd
                if (mid % 2 != 0) {
                    r = mid - 1; // Single element is on the left
                } else {
                    l = mid + 2; // Single element is on the right
                }
            }
        }
        
        return -1;
    }
}