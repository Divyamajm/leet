class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int max=-1;
        int[] arr1=new int[n];
        for(int i=n-1;i>=0;i--){
            arr1[i]=max;
            max=Math.max(max,arr[i]);
        }
        return arr1;
    }
}