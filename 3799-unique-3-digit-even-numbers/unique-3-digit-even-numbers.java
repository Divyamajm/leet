class Solution {
    public int totalNumbers(int[] digits) {
        // 1. Build our frequency map for the input array
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }
        
        int count = 0;
        
        // 2. Just check every possible 3-digit even number (100, 102, 104 ... 998)
        for (int i = 100; i <= 998; i += 2) {
            // Count what digits are required to build the current number 'i'
            int[] requiredFreq = new int[10];
            requiredFreq[i % 10]++;         // Ones place
            requiredFreq[(i / 10) % 10]++;  // Tens place
            requiredFreq[i / 100]++;        // Hundreds place
            
            // 3. Check if our input array has enough of each required digit
            boolean canBuild = true;
            for (int j = 0; j < 10; j++) {
                if (requiredFreq[j] > freq[j]) {
                    canBuild = false;
                    break;
                }
            }
            
            // If we have the parts, it's a valid number!
            if (canBuild) {
                count++;
            }
        }
        
        return count;
    }
}