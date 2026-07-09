// -----------------Recursive-----------
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();

//         Integer[][] dp = new Integer[n][n];

//         return helper(0, 0, triangle, dp);
//     }

//     public int helper(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
//         if (i == triangle.size() - 1) {
//             return triangle.get(i).get(j);
//         }

//         if (dp[i][j] != null) {
//             return dp[i][j];
//         }

//         return dp[i][j] = triangle.get(i).get(j)
//                 + Math.min(helper(i + 1, j, triangle, dp), helper(i + 1, j + 1, triangle, dp));
//     }
// }

class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();

        int[] dp = new int[n];

        for(int i = 0; i<n; i++){
            dp[i] = triangle.get(n-1).get(i);
        } 

        for(int i = n-2; i>= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}