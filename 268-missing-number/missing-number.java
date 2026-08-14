class Solution {
    public int missingNumber(int[] nums) {
        int total=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int sum=((n+1)*(n))/2;
        return sum-total;
    }
}