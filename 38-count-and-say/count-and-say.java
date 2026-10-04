class Solution {
    public String countAndSay(int n) {
        // Base case: the 1st sequence is always "1"
        String s = "1";
        // Build the sequence iteratively up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            // Iterate through the current string to generate the next one
            for (int j = 1; j < s.length(); j++) {
                // If the current character matches the previous one, just increase the count
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } 
                // If it's different, we finalize the previous group
                else {
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1; // Reset count for the new character
                }
            }
            // We must append the final counted group outside the loop.
            sb.append(count).append(s.charAt(s.length() - 1));
            // Update s to be the newly generated sequence for the next iteration
            s = sb.toString();
        }
        return s;
    }
}