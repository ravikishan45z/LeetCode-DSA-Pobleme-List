class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;

        Integer[][] ans = new Integer[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int index = i * n + j;
                int nxt = (index + k) % total;
                ans[nxt / n][nxt % n] = grid[i][j];
            }
        }

        List<List<Integer>> mat = new ArrayList<>();
        for(Integer[] row : ans){
            mat.add(Arrays.asList(row));
        }

        return mat;
    }
}