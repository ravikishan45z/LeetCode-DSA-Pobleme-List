class Solution {
    public int maxSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n -3; j++) {
                int sum = nums[i][j] + nums[i][j + 1] + nums[i][j + 2]
                        + nums[i + 1][j + 1]
                        + nums[i + 2][j] + nums[i + 2][j + 1] + nums[i + 2][j + 2];

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}