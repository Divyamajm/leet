class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>s=new Stack();
        int[] nge=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            // if(nums[i]<s.peek()){
            //     s.push(nums[i]);
            // }
            while(!s.isEmpty()&&nums2[i]>s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i]=-1;
            }
            else{
                nge[i]=s.peek();
            }
            s.push(nums2[i]);
        }
        int[]result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    result[i]=nge[j];
                }
            }
        }
        return result;
    }
}