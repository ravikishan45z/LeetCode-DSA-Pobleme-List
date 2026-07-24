class Solution {
    public int[][] flipAndInvertImage(int[][] nums) {
        for (int[] ele : nums) {
            reverse(ele);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = 0;
                }
            }
        }
        return nums;
    }

    public void reverse(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}