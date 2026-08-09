import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // CHANGE 1: Renamed from 'Pair' to 'Node'. 
    // Using 'row, col, time' instead of 'first, second, third' prevents confusion.
    class Node {
        int row, col, time;
        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        
        // CHANGE 2: Clearer variable names for your counters
        int countFresh = 0;  
        
        // 1. Setup Phase: Find all rotten oranges and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = 2; // Mark initially rotten oranges as 2
                } else if (grid[i][j] == 1) {
                    countFresh++; // Tally up how many fresh ones exist
                }
            }
        }
        
        int time = 0;
        int countRotted = 0; // Tracks how many fresh oranges we successfully rot
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        // 2. BFS Engine Phase
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            
            time = Math.max(time, t);
            
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                
                // CHANGE 3: The Golden Rule -> Check EXACTLY 0 for unvisited
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    
                    q.add(new Node(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2; // Lock the door so it can't be added again
                    countRotted++;
                }
            }
        }
        
        // 3. Verification Phase
        if (countFresh != countRotted) {
            return -1; // Some oranges were unreachable
        }
        
        return time;
    }
}