class Solution {
    // 1. Helper to reverse a portion of the array
    public void reverse(char[] a, int start, int end) {
        while (start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        // STEP 1: Clean spaces (remove leading, trailing, and extra spaces)
        int i = 0; // i will keep track of the valid string length
        int j = 0; // j will scan through the original array
        
        while (j < n) {
            while (j < n && a[j] == ' ') j++; // Skip spaces
            
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++]; // Copy non-space characters
            }
            
            while (j < n && a[j] == ' ') j++; // Skip trailing spaces
            
            if (j < n) a[i++] = ' '; // Add a single space between words
        }
        
        // 'i' is now the exact length of the cleaned string.
        
        // STEP 2: Reverse the entire cleaned string
        reverse(a, 0, i - 1);
        
        // STEP 3: Reverse each word individually
        int start = 0;
        int end = 0;
        
        while (end < i) {
            // Find the end of the current word
            while (end < i && a[end] != ' ') end++;
            
            // Reverse just the word
            reverse(a, start, end - 1);
            
            // Jump to the start of the next word
            start = end + 1;
            end++;
        }
        
        // Return only the valid part of the array
        return new String(a, 0, i);
    }
}