class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // If depth is > 0, it is an inner bracket. Keep it!
                if (depth > 0) {
                    sb.append(c);
                }
                depth++; // We are going deeper
            } 
            else if (c == ')') {
                depth--; // We are coming back up
                
                // If depth is still > 0, we haven't hit the very outside yet. Keep it!
                if (depth > 0) {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}