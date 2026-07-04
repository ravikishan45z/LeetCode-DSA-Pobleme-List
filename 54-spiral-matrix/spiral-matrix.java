class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        List<Integer> ans = new ArrayList<>();

        int srow = 0, scol = 0;
        int erow = m - 1, ecol = n - 1;

        while (srow <= erow && scol <= ecol) {
            //top
            for (int j = scol; j <= ecol; j++) {
                ans.add(nums[srow][j]);
            }

            //right
            for (int i = srow + 1; i <= erow; i++) {
                ans.add(nums[i][ecol]);
            }

            //bottom
            for (int j = ecol - 1; j >= scol; j--) {
                if (srow == erow) {
                    break;
                }
                ans.add(nums[erow][j]);
            }

            //left
            for (int i = erow - 1; i >= scol+1; i--) {
                if (scol == ecol) {
                    break;
                }
                ans.add(nums[i][scol]);
            }
            srow++;
            erow--;
            scol++;
            ecol--;
        }
        return ans;
    }
}