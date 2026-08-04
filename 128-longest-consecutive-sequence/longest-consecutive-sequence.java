class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(int num:set){
            int start=1;
            int ind=1;
            if(!set.contains(num-1)){
                // start=1
                while(set.contains(num+ind)){
                    start++;
                    ind++;
                }max=Math.max(max,start);
            }
        }return max;
    }
}