class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // 1. Find the FIRST occurrence
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[0] = mid;     // Target found! Record it.
                r = mid - 1;         // Keep searching left for earlier occurrences
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        // If target wasn't found in the first loop, we can exit early
        if (result[0] == -1) {
            return result;
        }
        
        // 2. Find the LAST occurrence
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[1] = mid;     // Target found! Record it.
                l = mid + 1;         // Keep searching right for later occurrences
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return result;
    }
}