class Solution {
    private void dfs(int ind,int[][] isConnected,boolean[] visited){
        visited[ind]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[ind][i]==1&&!visited[i]){
                dfs(i,isConnected,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }return count;
    }
}