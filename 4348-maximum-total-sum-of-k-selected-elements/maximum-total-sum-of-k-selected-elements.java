class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            if (mul == 0) {
                sum += 1L * nums[n - 1 - i];
                continue;  // skip the multiplication line
            }
            sum += 1L * nums[n - 1 - i] * mul;
            mul--;
        }
        return sum;
    }
}