class Solution {
    public void helper(List<List<Integer>>result,List<Integer>current,int[] nums,int level){
        result.add(new ArrayList<>(current));
        for(int i=level;i<nums.length;i++){
            current.add(nums[i]);
            helper(result,current,nums,i+1);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,new ArrayList<>(),nums,0);
        return result;
    }
}