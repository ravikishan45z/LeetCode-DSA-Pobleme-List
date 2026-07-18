class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);
        
        int n = arr.size();
        for(int i = 0; i<n-1; i++){
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i+1);
            a.right = b;
            a.left = null;
        }
        TreeNode last = arr.get(n-1);
        last.left = null;
        last.right = null;
    }
    public static void dfs(TreeNode root, ArrayList<TreeNode> arr){
        if(root == null){
            return;
        }
        arr.add(root);
        dfs(root.left,arr);
        dfs(root.right,arr);
    }   
}