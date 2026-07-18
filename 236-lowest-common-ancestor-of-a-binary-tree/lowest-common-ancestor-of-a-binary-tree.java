class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // Agar current node hi p ya q hai
        if (root == p || root == q) {
            return root;
        }

        boolean pLeft = exists(root.left, p);
        boolean qLeft = exists(root.left, q);

        // Dono left subtree mein hain
        if (pLeft && qLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Dono right subtree mein hain
        if (!pLeft && !qLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Ek left mein aur ek right mein (ya current root p/q hai)
        return root;
    }

    public boolean exists(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root == node) {
            return true;
        }

        return exists(root.left, node) || exists(root.right, node);
    }
}