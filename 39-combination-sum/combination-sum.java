class Solution {
    public void helper(int[] candidates,int target,List<List<Integer>>result,List<Integer>current,int ind,int sum){
        if(target==sum){
            result.add(new ArrayList<>(current));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        if(sum+candidates[ind]<=target){
            current.add(candidates[ind]);
            helper(candidates,target,result,current,ind,sum+candidates[ind]);
            current.remove(current.size()-1);
        }
        
        helper(candidates,target,result,current,ind+1,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList<>();
        helper(candidates,target,result,new ArrayList(),0,0);
        return result;
    }
}