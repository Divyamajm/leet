import java.util.LinkedList;
import java.util.Queue;

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
    // Helper class to pair each TreeNode with its normalized position index
    private static class NodePos {
        TreeNode node;
        int index;

        NodePos(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<NodePos> queue = new LinkedList<>();
        queue.offer(new NodePos(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int minIndex = queue.peek().index; // Index of the leftmost node at this level
            int first = 0;
            int last = 0;

            for (int i = 0; i < levelSize; i++) {
                NodePos current = queue.poll();
                // Normalize index to prevent overflow on deep trees
                int normalizedIndex = current.index - minIndex;

                if (i == 0) {
                    first = normalizedIndex;
                }
                if (i == levelSize - 1) {
                    last = normalizedIndex;
                }

                if (current.node.left != null) {
                    queue.offer(new NodePos(current.node.left, 2 * normalizedIndex));
                }
                if (current.node.right != null) {
                    queue.offer(new NodePos(current.node.right, 2 * normalizedIndex + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}