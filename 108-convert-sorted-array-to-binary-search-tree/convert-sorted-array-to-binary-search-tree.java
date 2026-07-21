class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }

    public TreeNode convert(int[] arr, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = convert(arr, lo, mid - 1);
        root.right = convert(arr, mid + 1, hi);

        return root;
    }
}