class Solution {
    public void helper(int[] nums,Set<List<Integer>>result,List<Integer>current,int ind){
        result.add(new ArrayList<>(current));
        for(int i=ind;i<nums.length;i++){
            current.add(nums[i]);
            helper(nums,result,current,i+1);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>>result=new HashSet();
        Arrays.sort(nums);
        helper(nums,result,new ArrayList(),0);
        List<List<Integer>>final1=new ArrayList<>(result);
        return final1;
    }
}