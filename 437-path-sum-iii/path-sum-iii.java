class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        return dfs(root,(long) sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int dfs(TreeNode root, long sum){
        if(root == null) return 0;

        int count = 0;
        if(sum == root.val) count++;

        count += dfs(root.left, sum- root.val);
        count += dfs(root.right, sum- root.val);

        return count;
    }
}