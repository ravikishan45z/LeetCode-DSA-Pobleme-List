/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        bfs(ans, root, 0);
        return ans;
    }
    public void bfs(List<List<Integer>> ans, TreeNode root, int level){
        if(root == null) return;
        if(level >= ans.size()) {
            ans.add(0, new ArrayList<>());
        }
        bfs(ans, root.left, level+1);
        bfs(ans, root.right, level+1);
        ans.get(ans.size() - level - 1).add(root.val);
    }
}