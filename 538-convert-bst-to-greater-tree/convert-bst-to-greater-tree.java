class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    public void reverseInorder(TreeNode root){
        if(root == null) return;
        // Right call
        reverseInorder(root.right);
        // Adding value
        sum += root.val;
        root.val = sum;
        // left call
        reverseInorder(root.left);
    }
}