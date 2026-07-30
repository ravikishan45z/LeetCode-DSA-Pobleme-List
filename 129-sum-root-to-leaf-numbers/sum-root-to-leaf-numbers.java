class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    public void dfs(TreeNode root, int path){
        if(root == null) return;
        path = path * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += path;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }
}