class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> all = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        // Generate all sequential numbers
        for (int len = 2; len <= 9; len++) {
            for (int start = 1; start <= 10 - len; start++) {

                int num = 0;

                for (int d = start; d < start + len; d++) {
                    num = num * 10 + d;
                }

                all.add(num);
            }
        }

        // Filter numbers in range
        for (int num : all) {
            if (num >= low && num <= high) {
                ans.add(num);
            }
        }

        return ans;
    }
}