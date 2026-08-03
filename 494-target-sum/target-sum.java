class Solution {
    private int helper(int index,int[] nums,int target,HashMap<String,Integer>map){
        if(index==0){
            if(nums[0]==target&&nums[0]==target*-1){
                return 2;
            }
            else if(nums[0]==target||nums[0]==target*-1){
                return 1;
            }
            return 0;
        }
        String s=index+","+target;
        if(map.containsKey(s)){
            return map.get(s);
        }
        int l=0;
        if(index>0){l=helper(index-1,nums,target-nums[index],map);}
        int r=0;
        if(index>0){r=helper(index-1,nums,target+nums[index],map);}
        // dp[index][target]=l+r;
        map.put(s,l+r);
        return l+r;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        HashMap<String,Integer> map=new HashMap();
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        return helper(n-1,nums,target,map);
    }
}