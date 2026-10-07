class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Exact(goal) = AtMost(goal) - AtMost(goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // This is exactly the code you just wrote
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0; // Edge case for goal - 1 when goal is 0
        
        int r = 0;
        int l = 0;
        int sum = 0;
        int count = 0;
        int n = nums.length;
        
        while (r < n) {
            sum += nums[r];
            
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            
            count += r - l + 1;
            r++;
        }
        
        return count;
    }
}