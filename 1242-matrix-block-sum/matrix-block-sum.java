class Solution {
    public int[][] matrixBlockSum(int[][] nums, int k) {
        // ------------BruteForce----------
        // int m = mat.length;
        // int n = mat[0].length;
        // int[][] ans = new int[m][n];

        // for(int i = 0; i<m; i++) {
        //     for(int j = 0; j<n; j++) {
        //         int sum = 0;

        //         for(int row = Math.max(0, i-k); row <= i+k && row < m; row++){
        //             for(int col = Math.max(0, j-k); col <= j+k && col < n; col++){
        //                 sum += mat[row][col];
        //             }
        //         }
        //         ans[i][j] = sum;
        //     }
        // }
        // return ans;
        int m = nums.length;
        int n = nums[0].length;
        int[][] prefix = new int[m+1][n+1];

        for(int i = 1; i<=m; i++){
            for(int j= 1; j<= n; j++){
                prefix[i][j] = nums[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]; 
            }
        }

        int[][] ans = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                int r1 = Math.max(0, i-k);
                int c1 = Math.max(0, j-k);
                int r2 = Math.min(m-1, i+k);
                int c2 = Math.min(n-1, j+k);
                r1++;
                c1++;
                r2++;
                c2++;

                ans[i][j] =  prefix[r2][c2] - prefix[r1- 1][c2] - prefix[r2][c1-1] + prefix[r1 - 1][c1 -1];
            }
        }

        return ans;
    }
}
