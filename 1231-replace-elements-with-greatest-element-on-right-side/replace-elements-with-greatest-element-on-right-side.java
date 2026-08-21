class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        Stack<Integer>s=new Stack();
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                s.push(-1);
                nge[i]=-1;
            }
            else{
                nge[i]=s.peek();
            }
            if(!s.isEmpty()&&arr[i]>s.peek()){
                s.push(arr[i]);
            }
        }return nge;
    }
}