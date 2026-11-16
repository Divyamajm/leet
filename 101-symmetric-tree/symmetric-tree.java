class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        // 1. Both reached the bottom at the same time -> symmetric so far
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }

        // 2. Only one side is null -> shapes don't match
        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }

        // 3. Both exist, but their values are different
        if (leftSubtree.val != rightSubtree.val) {
            return false;
        }

        // 4. Check outer pair (left's left vs right's right) 
        //    AND inner pair (left's right vs right's left)
        boolean outerMatch = isMirror(leftSubtree.left, rightSubtree.right);
        boolean innerMatch = isMirror(leftSubtree.right, rightSubtree.left);

        return outerMatch && innerMatch;
    }
}