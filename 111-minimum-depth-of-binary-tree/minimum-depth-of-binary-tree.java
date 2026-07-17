class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return level(root);
    }

    public int level(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null)
            return level(root.right) + 1;

        if (root.right == null)
            return level(root.left) + 1;

        return Math.min(level(root.left), level(root.right)) + 1;
    }
}