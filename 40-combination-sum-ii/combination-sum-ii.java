class Solution {
    private void helper(int index,int[] candidates,int target,Set<List<Integer>> result,List<Integer> current){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(candidates.length==index){
            return;
        }
        if(candidates[index]<=target){
            current.add(candidates[index]);
            helper(index+1,candidates,target-candidates[index],result,current);
            current.remove(current.size()-1);
        }
        while(index+1<candidates.length && candidates[index]==candidates[index+1]){
            index++;
        }
        helper(index+1,candidates,target,result,current);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result=new HashSet();
        Arrays.sort(candidates);
        helper(0,candidates,target,result,new ArrayList<>());
        List<List<Integer>> result1=new ArrayList<>(result);
        return result1;
    }
}