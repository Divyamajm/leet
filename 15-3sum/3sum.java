class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array. This is CRUCIAL for easily skipping duplicates
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate 'i' values to prevent duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 3: Two Pointers to find the remaining two numbers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // We found a valid triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate 'left' values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate 'right' values
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward to look for other combinations
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    // The sum is too small, we need a bigger number. 
                    // Since the array is sorted, moving 'left' to the right increases the sum.
                    left++;
                } 
                else {
                    // The sum is too big, we need a smaller number.
                    // Moving 'right' to the left decreases the sum.
                    right--;
                }
            }
        }
        
        return result;
    }
}