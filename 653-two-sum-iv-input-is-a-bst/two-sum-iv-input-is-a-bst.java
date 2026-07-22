class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int sum = arr.get(l) + arr.get(r);
            if (sum == k)
                return true;
            else if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    public void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}