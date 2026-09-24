class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            int total=0;
            while(x>0){
                int y=x%10;
                total+=y;
                x=x/10;
            }
            if(total==i){
                return i;
            }
        }
        return -1;
    }
}