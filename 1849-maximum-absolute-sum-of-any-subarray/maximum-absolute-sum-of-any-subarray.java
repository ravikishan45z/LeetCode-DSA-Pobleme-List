class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        int minSum = 0;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            minSum = Math.min(sum, minSum);
        }
        return maxSum - minSum;
    }
}