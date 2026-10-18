class Solution {
    public void helper(int[] nums,Set<List<Integer>>result,List<Integer>current,int ind){
        result.add(new ArrayList<>(current));
        if(ind==nums.length){
            return;
        }
        current.add(nums[ind]);
        helper(nums,result,current,ind+1);
        current.remove(current.size()-1);
        helper(nums,result,current,ind+1);
        // for(int i=ind;i<nums.length;i++){
            
        // }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>>result=new HashSet();
        Arrays.sort(nums);
        helper(nums,result,new ArrayList(),0);
        List<List<Integer>>final1=new ArrayList<>(result);
        // Co
        return final1;
    }
}