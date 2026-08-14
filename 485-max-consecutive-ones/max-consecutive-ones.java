class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0;
        int r=0;
        int n=nums.length-1;
        int maxLength=0;
        while(r<=n){
            if(nums[r]==0){
                l=r+1;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }return maxLength;
    }
}