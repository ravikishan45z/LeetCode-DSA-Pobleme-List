class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long curr = nums[i];

            // Smallest number >= curr - valueDiff
            Long candidate = set.ceiling(curr - valueDiff);

            // Check whether candidate is within allowed range
            if (candidate != null && candidate <= curr + valueDiff) {
                return true;
            }

            set.add(curr);

            // Maintain window of at most indexDiff elements
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}