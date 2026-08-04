class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums;

        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        int index = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = nums[index];
            index++;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = nums[index];
            index++;
        }
        
        sortArray(a);
        sortArray(b);

        // Step 4: Call the helper function;
        merge(a, b, nums);
        return nums;
    }

    private static void merge(int[] a, int[] b, int[] nums) {
        // Merge to sortef numsay to one numsay.
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                nums[k] = a[i];
                i++;
                k++;
            } else {
                nums[k] = b[j];
                k++;
                j++;
            }
        }

        // left element of numsay "a";
        while (i < a.length) {
            nums[k] = a[i];
            k++;
            i++;
        }

        // left element of numsay "b";
        while (j < b.length) {
            nums[k] = b[j];
            k++;
            j++;
        }
    }
}