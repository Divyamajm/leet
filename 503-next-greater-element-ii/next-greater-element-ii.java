class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];
        Stack<Integer>s=new Stack();
        for(int i=n*2-1;i>=0;i--){
            while(!s.isEmpty()&&nums[i%n]>=s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i%n]=-1;
            }
            else{
                nge[i%n]=s.peek();
            }
            s.push(nums[i%n]);
        }
        return nge;
    }
}