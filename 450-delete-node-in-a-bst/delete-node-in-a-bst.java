class Solution {
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root == null) return null;
		if (root.val > target) { // go left
			root.left = deleteNode(root.left, target);
		} else if (root.val < target) {
			root.right = deleteNode(root.right, target); // go right
		} else { // mil gaya
		
            // case 1 : if Root is leaf Node
            if(root.left == null && root.right == null){
                return null; 
            }
            
            // Case 2 : if Root have only one child.
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            // Case 3: if root have two child.
            TreeNode pred = root.left;
            while(pred.right != null){
                pred = pred.right;
            }
            root.left = deleteNode(root.left, pred.val);
            pred.left = root.left;
            pred.right = root.right;
            return pred;
		}
		return root;
    }
}