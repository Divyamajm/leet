class Solution {
    private void dfs(int[][] grid,int row,int col,int[][] visited){
        int n=grid.length;
        int m=grid[0].length;
        visited[row][col]=1;
        // grid[row][col]=0;
        int[] delRow={1,0,-1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(grid,nrow,ncol,visited);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] visited=new int[n][m];
        // int[][] visited=new int[n][m];
        for(int j = 0; j < m; j++) {
            // Top row
            if(grid[0][j] == 1) {
                dfs(grid, 0, j, visited);
            }
            // Bottom row
            if(grid[n-1][j] == 1) {
                dfs(grid, n-1, j, visited);
            }
        }
        
        // 2. Traverse First and Last Columns (Iterating down rows, so limit is 'n')
        for(int i = 0; i < n; i++) {
            // Left column
            if(grid[i][0] == 1) {
                dfs(grid, i, 0, visited);
            }
            // Right column
            if(grid[i][m-1] == 1) {
                dfs(grid, i, m-1, visited);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                    count++;
                }
            }
        }return count;
    }
}