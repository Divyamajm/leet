import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // FIX: Changed method name from 'minimumMoves' to 'minMoves'
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        // Map to store the bit-index of each litter
        int[][] litterIdx = new int[m][n];
        for (int[] row : litterIdx) {
            Arrays.fill(row, -1);
        }
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        
        // Parse the grid to find Start and assign IDs to Litter
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterIdx[r][c] = litterCount++;
                }
            }
        }
        
        // If there is no litter to collect, we are already done
        if (litterCount == 0) return 0;
        
        // Target bitmask when ALL litter is collected
        int targetMask = (1 << litterCount) - 1;
        
        // Initialize our 3D tracking array with -1
        int[][][] maxEnergyAt = new int[m][n][1 << litterCount];
        for (int[][] arr2d : maxEnergyAt) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
        
        // Setup the BFS Queue: {row, col, current_mask, current_energy}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0, energy});
        maxEnergyAt[startR][startC][0] = energy;
        
        int steps = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // Execute BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int currE = curr[3];
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        char ch = classroom[nr].charAt(nc);
                        
                        if (ch == 'X') continue;
                        
                        int nEnergy = currE - 1;
                        if (nEnergy < 0) continue;
                        
                        int nMask = mask;
                        
                        if (ch == 'L') {
                            nMask |= (1 << litterIdx[nr][nc]);
                        }
                        
                        if (ch == 'R') {
                            nEnergy = energy; 
                        }
                        
                        if (nEnergy > maxEnergyAt[nr][nc][nMask]) {
                            maxEnergyAt[nr][nc][nMask] = nEnergy;
                            
                            if (nMask == targetMask) return steps + 1;
                            
                            queue.offer(new int[]{nr, nc, nMask, nEnergy});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}