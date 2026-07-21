class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return 0;
        ArrayList<Integer> ans = new  ArrayList<>();
        dfs(root,ans);
        long min = Long.MAX_VALUE;
        long Smin = Long.MAX_VALUE;
        for(int i = 0; i< ans.size(); i++){
            if(ans.get(i) < min){
                Smin = min;
                min = ans.get(i);
            }else if(ans.get(i) < Smin && ans.get(i) != min){
                Smin = ans.get(i);
            }
        }
        if(Smin == Long.MAX_VALUE) return -1;
        return (int)Smin;
    }
    public void dfs(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}