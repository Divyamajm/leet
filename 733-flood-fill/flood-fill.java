class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    private void bfs(int row,int col,int[][] visited,int[][]image,int x,int color){
        visited[row][col]=1;
        image[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(row,col));
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();
            for(int i=0;i<4;i++){
                int nRow=r+delRow[i];
                int nCol=c+delCol[i];
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&visited[nRow][nCol]==0&&image[nRow][nCol]==x){
                    bfs(nRow,nCol,visited,image,x,color);
                }
            }
        }
        // for(int i=0;i<4;i++){
        //     int r=
        // }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] visited=new int[n][m];
        int x=image[sr][sc];
        bfs(sr,sc,visited,image,x,color);
        return image;
    }
}