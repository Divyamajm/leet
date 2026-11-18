class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=0;
        int x=-1;
        for(int i=0;i<n;i++){
            if(count==0){
                x=nums[i];
                count++;
            }
            else{
                if(x==nums[i]){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        return x;
    }
}