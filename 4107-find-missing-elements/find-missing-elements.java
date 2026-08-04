class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int[] array=new int[max-min+1];
        Arrays.fill(array,-1);
        for(int i=0;i<n;i++){
            array[nums[i]-min]=nums[i];
        }
        for(int i=0;i<max-min+1;i++){
            if(array[i]==-1){
                result.add(min+i);
            }
        }return result;
    }
}