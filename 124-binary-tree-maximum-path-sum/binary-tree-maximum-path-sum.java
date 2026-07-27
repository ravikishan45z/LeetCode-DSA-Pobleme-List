class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(0, maxSum(root.left));
        int rightSum = Math.max(0, maxSum(root.right));
        max = Math.max(max, root.val+leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}