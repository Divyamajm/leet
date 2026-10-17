class Solution {
    public void helper(int[] nums,int ind,List<List<Integer>>result,List<Integer>current){
        if(ind==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[ind]);
        helper(nums,ind+1,result,current);
        current.remove(current.size()-1);
        helper(nums,ind+1,result,current);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());
        // Collections.sort(result);
        return result;
    }
}