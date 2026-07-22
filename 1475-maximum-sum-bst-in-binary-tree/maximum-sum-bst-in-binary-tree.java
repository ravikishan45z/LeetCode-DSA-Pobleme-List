class quad{
    int max;
    int min;
    int sum;
    boolean isBst;
    quad(int max, int min, int sum, boolean isBst){
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBst = isBst;
    }
}
class Solution {
    static int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        helper(root);
        return maxSum;
    }
    static quad helper(TreeNode root){
        if(root == null){
            return new quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }
        quad lst = helper(root.left);
        quad rst = helper(root.right);
        
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int sum = root.val + lst.sum + rst.sum;
        boolean isBst = lst.isBst && rst.isBst && (lst.max < root.val) && (rst.min > root.val);
        if(isBst){
            maxSum = Math.max(sum, maxSum);
        }
        return new quad(max, min, sum, isBst);
    }
}