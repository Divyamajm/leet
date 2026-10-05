class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length-1;
        int l=0;
        int r=0;
        while(r<=n){
            if(nums[r]==0){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r++;
            }
            else if(nums[r]==1){
                r++;
            }
            else{
                int temp=nums[r];
                nums[r]=nums[n];
                nums[n]=temp;
                n--;
            }
        }
    }
}