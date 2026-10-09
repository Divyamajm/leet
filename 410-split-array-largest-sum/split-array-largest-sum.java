class Solution {
    // true if nums can be split into <= k subarrays, each sum <= mid
    private boolean canSplit(int[] nums, int k, int mid) {
        int pieces = 1;
        int total = 0;
        for (int num : nums) {
            if (total + num > mid) {
                pieces++;
                total = num;
            } else {
                total += num;
            }
        }
        return pieces <= k;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);   // lower bound: largest element
            r += num;               // upper bound: total sum
        }
        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                r = mid - 1;        // feasible: try smaller
            } else {
                l = mid + 1;        // infeasible: need larger
            }
        }
        return ans;
    }
}