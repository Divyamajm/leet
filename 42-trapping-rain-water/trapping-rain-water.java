class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] nge=new int[n];
        int[] pge=new int[n];
        int total=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            pge[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            nge[i]=max;
        }
        for(int i=0;i<n;i++){
            total+=Math.min(nge[i],pge[i])-height[i];
        }
        return total;
    }
}