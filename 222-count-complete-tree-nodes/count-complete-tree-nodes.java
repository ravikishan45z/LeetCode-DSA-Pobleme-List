class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = leftheight(root);
        int right = rightheight(root);

        if(left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    } 

    public int leftheight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    public int rightheight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}