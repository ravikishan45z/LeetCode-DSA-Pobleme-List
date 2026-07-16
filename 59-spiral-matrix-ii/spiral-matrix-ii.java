class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, down = n - 1;
        int left = 0, right = n - 1;

        int ele = 1;
        while (ele <= n * n) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = ele++;
            }
            top++;

            for (int row = top; row <= down; row++) {
                matrix[row][right] = ele++;
            }
            right--;

            if (top <= down) {
                for (int col = right; col >= left && ele <= n * n; col--) {
                    matrix[down][col] = ele++;
                }
                down--;
            }
            if (left <= right) {
                for (int row = down; row >= top && ele <= n * n; row--) {
                    matrix[row][left] = ele++;
                }
                left++;
            }
        }
        return matrix;
    }
}