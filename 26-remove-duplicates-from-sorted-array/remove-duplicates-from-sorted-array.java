class Solution {
    public int removeDuplicates(int[] nums) {
        int j=1;
        int n=nums.length;
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                nums[j++]=nums[i];
                count++;
            }
        }
        return count;
    }
}
// 0011122334