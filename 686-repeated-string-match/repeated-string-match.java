class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        // 1. Build the "Haystack" by repeating 'a' until it's at least as long as 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // 2. See if 'b' is hiding anywhere inside our new string
        if (sb.indexOf(b) != -1) {
            return count;
        }
        
        // 3. The Offset check: 'b' might wrap around the edges, so add 'a' ONE more time
        sb.append(a);
        count++;
        
        if (sb.indexOf(b) != -1) {
            return count;
        }
        
        // 4. If it's still not found, it is impossible
        return -1;
    }
}