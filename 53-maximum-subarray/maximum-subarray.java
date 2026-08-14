class Solution {
    public int maxSubArray(int[] nums) {
        int max=-1;
        int total=0;
        int n=nums.length;
        int maxTotal=Integer.MIN_VALUE;
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n;i++){
            total+=nums[i];
            maxTotal=Math.max(maxTotal,total);
            if(total<0){
                total=0;
            }
        }return maxTotal;
    }
}