class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(dfs(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean dfs(TreeNode root, TreeNode root2){
        if(root == null && root2 == null ){
            return true;
        }

        if(root == null || root2 == null){
            return false;
        }
        if(root.val != root2.val){
            return false;
        }

        return dfs(root.left, root2.left) && dfs(root.right, root2.right);
    }
}