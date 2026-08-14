class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] result=new int[2];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=nums[i];
            if(map.containsKey(target-x)){
                result[0]=i;
                result[1]=map.get(target-x);
                return result;
            }
            map.put(x,i);
        }
        return new int[]{-1,-1};
    }
}