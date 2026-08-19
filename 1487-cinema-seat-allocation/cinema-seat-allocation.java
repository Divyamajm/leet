class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each row
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Use bitmask to mark reserved seats
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Every completely empty row can fit 2 groups
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            // 2,3,4,5
            boolean left = (mask & ((1 << 2) | (1 << 3) |
                                    (1 << 4) | (1 << 5))) == 0;

            // 6,7,8,9
            boolean right = (mask & ((1 << 6) | (1 << 7) |
                                     (1 << 8) | (1 << 9))) == 0;

            // 4,5,6,7
            boolean middle = (mask & ((1 << 4) | (1 << 5) |
                                      (1 << 6) | (1 << 7))) == 0;

            if (left && right) {
                // Can put two groups:
                // [2,3,4,5] and [6,7,8,9]
                ans += 2;
            } 
            else if (left || middle || right) {
                // Can put exactly one group
                ans += 1;
            }
        }

        return ans;
    }
}