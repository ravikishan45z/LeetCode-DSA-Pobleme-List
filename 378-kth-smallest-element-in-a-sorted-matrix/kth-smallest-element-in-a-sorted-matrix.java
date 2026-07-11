class Solution {
    public int kthSmallest(int[][] nums, int k) {
        int m = nums.length;
        int n = nums[0].length;
        int s = m*n;
        int[] arr= new int[s];
        int l = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                arr[l] = nums[i][j];
                l++;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}