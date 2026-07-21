class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (level == ans.size()) {
            ans.add(new LinkedList<>());
        }

        LinkedList<Integer> curr = (LinkedList<Integer>) ans.get(level);

        if (level % 2 == 0)
            curr.addLast(root.val);
        else
            curr.addFirst(root.val);

        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }
}