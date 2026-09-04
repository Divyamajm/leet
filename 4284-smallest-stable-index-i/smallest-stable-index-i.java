class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] pge=new int[n];
        int[] nse=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            pge[i]=max;
        }
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            nse[i]=min;
        }
        for(int i=0;i<n;i++){
            if((pge[i]-nse[i])<=k){
                return i;
            }
        }
        return -1;
    }
}