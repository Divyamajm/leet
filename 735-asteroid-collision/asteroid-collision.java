import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                // Moving right: always push to stack
                s.push(asteroids[i]);
            } else {
                // Moving left: destroy all smaller right-moving asteroids
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroids[i])) {
                    s.pop();
                }
                
                if (s.isEmpty() || s.peek() < 0) {
                    // Incoming asteroid survived (stack is empty, or top is also moving left)
                    s.push(asteroids[i]);
                } else if (s.peek() == Math.abs(asteroids[i])) {
                    // Both asteroids are the same size and destroy each other
                    s.pop();
                }
                // If s.peek() > Math.abs(asteroids[i]), the incoming asteroid is destroyed. Do nothing.
            }
        }
        
        // Dump the stack into the result array
        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        
        return result;
    }
}