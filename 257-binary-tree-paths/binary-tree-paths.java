class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helperFunc(new StringBuilder(), root, result);
        return result;
    }

    private void helperFunc(StringBuilder path, TreeNode root, List<String> result) {
        if (root == null) {
            return;
        }
        int len = path.length();
        if (len != 0) {
            path.append("->");
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            helperFunc(path, root.left, result);
            helperFunc(path, root.right, result);
        }
        path.setLength(len);
    }
}