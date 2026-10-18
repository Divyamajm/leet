class Solution {
    public void helper(int[] candidates,int target,Set<List<Integer>>result,List<Integer>current,int ind,int sum){
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        // while()
        if(sum+candidates[ind]<=target){
            current.add(candidates[ind]);
            helper(candidates,target,result,current,ind+1,sum+candidates[ind]);
            current.remove(current.size()-1);
        }
        while(ind+1<candidates.length&&candidates[ind]==candidates[ind+1]){
            ind++;
        }
        helper(candidates,target,result,current,ind+1,sum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>>result=new HashSet();
        helper(candidates,target,result,new ArrayList(),0,0);
        List<List<Integer>>result1=new ArrayList<>(result);
        return result1;
    }
}