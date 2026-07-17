class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> arr = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }

    public void bfs(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode front = q.remove();
                arr.add(front.val);

                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }

            ans.add(arr);
        }
    }
}