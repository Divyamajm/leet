class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return n;
        }
        int count;
        int max=1;
        HashSet<Integer>set=new HashSet();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int c:set){
            if(set.contains(c-1)){
                continue;
            }
            count=1;
            int x=c;
            while(set.contains(x+1)){
                count++;
                x++;
                max=Math.max(max,count);
            }
        }
        return max;
    }
}