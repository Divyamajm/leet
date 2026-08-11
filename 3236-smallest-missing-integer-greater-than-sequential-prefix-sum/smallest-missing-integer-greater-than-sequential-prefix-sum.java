class Solution {
    public int missingInteger(int[] nums) {

        // Store all numbers for checking the final answer
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find the sequential prefix sum
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find the smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}