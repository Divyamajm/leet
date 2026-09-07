import java.util.HashSet;

class Solution {
    public int totalNumbers(int[] digits) {
        // HashSet automatically ignores duplicates
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 1. Ensure we are picking 3 distinct indices from the array
                    if (i == j || j == k || i == k) continue;
                    
                    // 2. Prevent leading zeros in the hundreds place
                    if (digits[i] == 0) continue;
                    
                    // 3. Ensure the ones place is an even number
                    if (digits[k] % 2 != 0) continue;
                    
                    // Construct the number and drop it into the set
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    set.add(num);
                }
            }
        }
        
        return set.size();
    }
}