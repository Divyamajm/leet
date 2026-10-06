class Solution {
    public void reverse(int start,int end,int[] nums){
        // int start=0;
        // int end=nums.length-1;
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
        int x=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<x){
                ind=i;
                break;
            }
            x=Math.max(x,nums[i]);
        }
        if(ind==-1){
            reverse(0,n-1,nums);
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
    }
}