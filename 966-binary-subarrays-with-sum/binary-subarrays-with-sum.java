class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
    private int atMost(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int l=0;
        int r=0;
        int n=nums.length-1;
        int count=0;
        int total=0;
        while(r<=n){
            total+=nums[r];
            while(total>goal){
                total-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}