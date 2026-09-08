class Solution {
    public void helper(int[] nums,int k,int n,List<List<Integer>>result,List<Integer>current,int ind,int sum){
        if(sum==n&&current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(ind==nums.length){
            return;
        }
        if(current.size()<k&&nums[ind]+sum<=n){
            current.add(nums[ind]);
            helper(nums,k,n,result,current,ind+1,sum+nums[ind]);
            current.remove(current.size()-1);
        }
        helper(nums,k,n,result,current,ind+1,sum);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>>result=new ArrayList<>();
        helper(nums,k,n,result,new ArrayList<>(),0,0);
        return result;
    }
}