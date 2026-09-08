import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length;
        int times = 0;
        int mod = 1_000_000_007;
        
        // 1. Precompute powers of 2 to avoid Math.pow() overflow
        int[] power = new int[n];
        power[0] = 1; // 2^0 = 1
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        // 2. Your flawless Two-Pointer logic!
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                // Look up the precomputed power instead of using Math.pow
                times = (times + power[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        
        return times;
    }
}