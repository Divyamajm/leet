class Solution {
    class Pair{
        int first;
        int second;
        int third;
        public Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] visited=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==0){
                    visited[i][j]=0;
                }
                else{
                    count++;
                }
            }
        }
        int cnt=0;
        int t=0;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int time=q.peek().third;
            q.poll();
            t=Math.max(time,t);
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&grid[nRow][nCol]==1&&visited[nRow][nCol]!=1){
                    q.add(new Pair(nRow,nCol,time+1));
                    visited[nRow][nCol]=1;
                    cnt++;
                }
            }
        }
        if(cnt!=count){
            return -1;
        }
        return t;
    }
}