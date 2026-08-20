class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        int l=0;
        int r=0;
        int count=0;
        int total=0;
        int n=nums.length-1;
        while(r<=n){
            if(nums[r]%2==1){
                count++;
            }
            while(count>k){
                if(nums[l]%2==1){
                    count--;
                }
                l++;
            }
            total+=r-l+1;
            r++;
        }
        return total;
    }
}