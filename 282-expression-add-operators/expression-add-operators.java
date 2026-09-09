import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        
        // Use StringBuilder for O(1) appends and deletes during backtracking
        helper(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, String num, int target, int pos, long eval, long prev) {
        // Base case: If we reached the end of the string
        if (pos == num.length()) {
            if (eval == target) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // TRAP 1: Prevent numbers with leading zeros (like "05")
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            // Extract the current number. Use long to prevent integer overflow!
            long curr = Long.parseLong(num.substring(pos, i + 1));
            
            // Save the current length of StringBuilder so we can cleanly backtrack
            int len = sb.length(); 

            // If we are at the very first number, we just add it without operators
            if (pos == 0) {
                sb.append(curr);
                helper(result, sb, num, target, i + 1, curr, curr);
                sb.setLength(len); // Backtrack
            } else {
                // Try Addition (+)
                sb.append("+").append(curr);
                helper(result, sb, num, target, i + 1, eval + curr, curr);
                sb.setLength(len); // Backtrack

                // Try Subtraction (-)
                sb.append("-").append(curr);
                helper(result, sb, num, target, i + 1, eval - curr, -curr);
                sb.setLength(len); // Backtrack

                // Try Multiplication (*) -> TRAP 2: Handle precedence
                sb.append("*").append(curr);
                helper(result, sb, num, target, i + 1, eval - prev + (prev * curr), prev * curr);
                sb.setLength(len); // Backtrack
            }
        }
    }
}