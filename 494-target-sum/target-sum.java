class Solution {
    private int helper(int index,int[] nums,int target){
        if(index==0){
            if(nums[0]==target&&nums[0]==target*-1){
                return 2;
            }
            else if(nums[0]==target||nums[0]==target*-1){
                return 1;
            }
            return 0;
        }
        int l=nums[index]+helper(index-1,nums,target-nums[index]);
        int r=-1*nums[index]+helper(index-1,nums,target+nums[index]);
        return l+r;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return helper(n-1,nums,target);
    }
}