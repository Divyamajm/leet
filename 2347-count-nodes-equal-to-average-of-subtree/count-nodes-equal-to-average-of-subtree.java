/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Global variable to keep track of valid nodes
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrderTraversal(root);
        return matchingNodesCount;
    }

    // Helper method returns an array: [sumOfSubtree, countOfNodes]
    private int[] postOrderTraversal(TreeNode node) {
        // Base case: If the node is null, sum is 0, count is 0.
        if (node == null) {
            return new int[]{0, 0};
        }

        // 1. Traverse Left
        int[] leftSubtree = postOrderTraversal(node.left);
        
        // 2. Traverse Right
        int[] rightSubtree = postOrderTraversal(node.right);

        // 3. Process Current Node
        int currentSum = leftSubtree[0] + rightSubtree[0] + node.val;
        int currentCount = leftSubtree[1] + rightSubtree[1] + 1;

        // Calculate average (integer division rounds down automatically in Java)
        int currentAverage = currentSum / currentCount;

        // Check if the current node matches the condition
        if (node.val == currentAverage) {
            matchingNodesCount++;
        }

        // Pass the sum and count up to the parent node
        return new int[]{currentSum, currentCount};
    }
}