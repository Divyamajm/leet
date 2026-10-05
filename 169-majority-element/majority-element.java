class Solution {
    public int majorityElement(int[] nums) {
        int r=0;
        int n=nums.length;
        int x=0;
        int count=0;
        while(r<n){
            if(count==0){
                x=nums[r];
                count++;
            }
            else{
                if(x==nums[r]){
                    count++;
                }
                else{
                    count--;
                }
            }
            r++;
        }
        return x;
    }
}