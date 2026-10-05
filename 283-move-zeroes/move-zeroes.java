class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int a=0;
        int count=0;
        for(int i=0;i<n;i++){
            int c=nums[i];
            if(c!=0){
                nums[a++]=nums[i];
                count++;
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(nums[i]);
        // }
        // System.out.println(count);
        for(int i=0;i<n-count;i++){
            nums[n-1-i]=0;
        }
    }
}