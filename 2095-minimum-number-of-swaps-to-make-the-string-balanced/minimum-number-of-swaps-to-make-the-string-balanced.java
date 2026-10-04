import java.util.Stack;

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Step 1: Logically check the string and cancel out valid pairs
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                stack.push(c); // Found an open bracket, wait for a match
            } 
            else { // c == ']'
                if (!stack.isEmpty()) {
                    // We found a matching pair! They cancel each other out.
                    stack.pop(); 
                }
                // (If the stack is empty, it means this ']' is invalid. 
                // We don't need to push it, because the problem guarantees 
                // the total number of '[' and ']' are exactly equal.)
            }
        }
        
        // Step 2: What is left in the stack?
        // The stack now contains ONLY the unmatched '[' brackets.
        // For example, if stack size is 2, we have "[[" left over.
        int unmatched = stack.size();
        
        // Step 3: Now we just swap them!
        // Swapping the outer brackets fixes 2 pairs at once.
        return (unmatched + 1) / 2;
    }
}