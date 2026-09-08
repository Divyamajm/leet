class Solution {
    public void helper(int[] candidates,int target,List<List<Integer>>result,List<Integer>current,int ind){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        if(candidates[ind]<=target){
            current.add(candidates[ind]);
            helper(candidates,target-candidates[ind],result,current,ind);
            current.remove(current.size()-1);
        }
        helper(candidates,target,result,current,ind+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList<>();
        helper(candidates,target,result,new ArrayList<>(),0);
        return result;
    }
}