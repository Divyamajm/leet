class Solution {
    public int missingNumber(int[] nums) {
        int x=0;
        int total=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            total=total^nums[i]^x;
            x++;
        }
        total^=n;
        return total;
    }
}