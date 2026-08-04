class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        Arrays.sort(nums);
        int j = 0;
        for (int i = min; i <= max; i++) {
            if (j < n && nums[j] == i) {
                while (j < n && nums[j] == i) {
                    j++;
                }
            } else {
                ans.add(i);
            }
        }

        return ans;
    }
}