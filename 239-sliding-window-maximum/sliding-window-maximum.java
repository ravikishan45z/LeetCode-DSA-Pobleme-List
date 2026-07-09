class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // ------------------Brute Force Method----------
        // int n = nums.length;
        // int[] result = new int[n - k + 1];
        // for (int i = 0; i <= n - k; i++) {
        //     int max = nums[i];
        //     for (int j = i; j < i + k; j++) {
        //         max = Math.max(max, nums[j]);
        //     }
        //     result[i] = max;
        // }
        // return result;

        //-----------------------Optimal----------------- 
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            // Store the maximum for the current window
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}