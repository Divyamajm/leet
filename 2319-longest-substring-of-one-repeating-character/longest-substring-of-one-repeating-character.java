class Solution {
    // 1. Define what each segment knows about itself
    class Node {
        int max;
        int prefLen, suffLen;
        char prefChar, suffChar;
        int size;
    }

    Node[] tree;
    char[] arr;

    // 2. The core logic: How to combine a Left segment and a Right segment
    private void merge(Node parent, Node left, Node right) {
        parent.size = left.size + right.size;
        parent.prefChar = left.prefChar;
        parent.suffChar = right.suffChar;
        
        // Calculate prefix length
        parent.prefLen = left.prefLen;
        // If the entire left side is one character, AND it matches the start of the right side
        if (left.prefLen == left.size && left.prefChar == right.prefChar) {
            parent.prefLen += right.prefLen;
        }
        
        // Calculate suffix length
        parent.suffLen = right.suffLen;
        // If the entire right side is one character, AND it matches the end of the left side
        if (right.suffLen == right.size && right.suffChar == left.suffChar) {
            parent.suffLen += left.suffLen;
        }
        
        // Calculate overall max length
        parent.max = Math.max(left.max, right.max);
        // Did a new max form across the boundary where they joined?
        if (left.suffChar == right.prefChar) {
            parent.max = Math.max(parent.max, left.suffLen + right.prefLen);
        }
    }

    // 3. Build the initial tree
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node();
            tree[node].max = 1;
            tree[node].prefLen = 1;
            tree[node].suffLen = 1;
            tree[node].prefChar = arr[start];
            tree[node].suffChar = arr[start];
            tree[node].size = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);
        
        tree[node] = new Node();
        merge(tree[node], tree[2 * node + 1], tree[2 * node + 2]);
    }

    // 4. Point Update logic
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            // Update the leaf node
            tree[node].prefChar = c;
            tree[node].suffChar = c;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, c);
        } else {
            update(2 * node + 2, mid + 1, end, idx, c);
        }
        // Recalculate parent after the child changes
        merge(tree[node], tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n]; // Safe size for a Segment Tree array
        
        // Build the tree initially in O(N)
        build(0, 0, n - 1);
        
        int k = queryIndices.length;
        int[] ans = new int[k];
        
        // Process each query in O(log N)
        for (int i = 0; i < k; i++) {
            update(0, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            // The root node (tree[0]) always holds the max for the entire array!
            ans[i] = tree[0].max; 
        }
        return ans;
    }
}