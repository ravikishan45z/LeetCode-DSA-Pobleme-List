class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {

            // Build histogram
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            max = Math.max(max, getMaxSum(heights));
        }

        return max;
    }

    // Largest Rectangle in Histogram
    public int getMaxSum(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        // Next Smaller Element
        int[] nse = new int[n];
        nse[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate Maximum Area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = nums[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}