class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        // Start the recursive backtracking with an empty StringBuilder
        backtrack(n, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(int n, StringBuilder current, List<String> result) {
        // Base Case: If our string has reached length 'n', save it and return
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }
        
        // Choice 1: We can ALWAYS add a '1' safely
        current.append('1');
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1); // undo the choice (backtrack)
        
        // Choice 2: We can only add a '0' if the string is empty OR the last char was '1'
        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
            current.append('0');
            backtrack(n, current, result);
            current.deleteCharAt(current.length() - 1); // undo the choice (backtrack)
        }
    }
}