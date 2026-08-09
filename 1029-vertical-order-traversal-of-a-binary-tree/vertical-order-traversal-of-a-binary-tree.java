class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        // {node, row, col}
        List<int[]> list = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair front = q.remove();

            TreeNode node = front.node;
            int row = front.row;
            int col = front.col;

            list.add(new int[]{row, col, node.val});

            if (node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        // Sort by column, then row, then value
        Collections.sort(list, (a, b) -> {

            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[2] - b[2];
        });

        int prevCol = Integer.MIN_VALUE;

        for (int[] curr : list) {

            int col = curr[1];
            int value = curr[2];

            if (col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = col;
            }

            ans.get(ans.size() - 1).add(value);
        }

        return ans;
    }
}