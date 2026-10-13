class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] nge1=new int[n1];
        int[] nge2=new int[n2];
        Stack<Integer>s=new Stack();
        for(int i=n2-1;i>=0;i--){
            while(!s.isEmpty()&&nums2[i]>s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                nge2[i]=-1;
            }
            else{
                nge2[i]=s.peek();
            }
            s.push(nums2[i]);
        }
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i]==nums2[j]){
                    nge1[i]=nge2[j];
                }
            }
        }
        return nge1;
    }
}