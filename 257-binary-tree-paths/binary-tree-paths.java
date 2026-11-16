class Solution {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public void ord(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }

        // Leaf node: finish the path without a trailing "->" and save it
        if (isLeaf(root)) {
            result.add(path + root.val);
            return;
        }

        // Internal node: append value + "->" and pass down to children
        ord(root.left, result, path + root.val + "->");
        ord(root.right, result, path + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        ord(root, result, "");
        return result;
    }
}