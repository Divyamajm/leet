class Solution {
    public int singleNumber(int[] nums) {
        int total=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            total^=nums[i];
        }
        return total;
    }
}