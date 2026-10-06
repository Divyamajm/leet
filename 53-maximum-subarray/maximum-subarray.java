class Solution {
    public int maxSubArray(int[] nums) {
        int r=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        // int maxSum=
        int sum=0;
        while(r<n){
            sum=sum+nums[r];
            max=Math.max(max,sum);
            if(sum<0){
                sum=0;
            }
            r++;
        }
        return max;
    }
}