class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        Stack<Integer>s=new Stack();
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=s.peek();
            }
            s.push(i);
        }
        int max=0;
        int total=0;
        for(int i=0;i<n;i++){
            total=heights[i]*(nse[i]-pse[i]-1);
            max=Math.max(max,total);
        }
        return max;
    }
}