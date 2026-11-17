import java.util.*;

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
    private TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, start, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        int minutes = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minutes++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Spread to left child
                if (current.left != null && visited.add(current.left)) {
                    queue.offer(current.left);
                }
                // Spread to right child
                if (current.right != null && visited.add(current.right)) {
                    queue.offer(current.right);
                }
                // Spread to parent
                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
        }

        return minutes;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, int start, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        if (node.val == start) {
            startNode = node;
        }
        parentMap.put(node, parent);
        buildParentMap(node.left, node, start, parentMap);
        buildParentMap(node.right, node, start, parentMap);
    }
}