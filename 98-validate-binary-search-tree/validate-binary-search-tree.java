class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        for(int i = 1; i<ans.size(); i++){
            if(ans.get(i-1) >= ans.get(i)) return false;
        }
        return true;
    }
    public void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}