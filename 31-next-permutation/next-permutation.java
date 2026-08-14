class Solution {
    private void reverse(int start,int end,int[] nums){
        int l=0;
        int r=0;
        int n=nums.length-1;
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,n-1,nums);
            return ;
        }
        else{
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[ind]){
                    int temp=nums[i];
                    nums[i]=nums[ind];
                    nums[ind]=temp;
                    reverse(ind+1,n-1,nums);
                    break;
                }
            }
        }
        return;
    }
}