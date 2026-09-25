// 1. Two Sum
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Input: nums = [3,3], target = 6
// Output: [0,1]
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