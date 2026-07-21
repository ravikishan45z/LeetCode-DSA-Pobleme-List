class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        int sum = left + right;

        if(root.val < low || root.val > high) return sum;

        return sum + root.val;
    }
}