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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        int[][] visited=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=0;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().third;
            dist[r][c]=t;
            q.poll();
            for(int i=0;i<4;i++){
                int nRow=r+delRow[i];
                int nCol=c+delCol[i];
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&visited[nRow][nCol]==0&&mat[nRow][nCol]==1){
                    visited[nRow][nCol]=1;
                    q.add(new Pair(nRow,nCol,t+1));
                }
            }
        }return dist;
    }
}