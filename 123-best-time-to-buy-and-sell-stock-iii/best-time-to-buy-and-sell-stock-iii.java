class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Bidirectional Dp logic
        // left to right traversasl.
        int min = prices[0];
        for(int i = 1; i< n; i++){
            // 1. update min.
            if(prices[i] < min){
                min = prices[i];
            }
            // 2. calculate current profit.
            int profit = prices[i] - min;
            // 3. update left dp array.
            left[i] = Math.max(left[i-1], profit);
        }

        // right to left traversal;
        int max = prices[n-1];
        for(int i = n-2; i>=0; i--){
            // 1. update max.
            if(prices[i] > max){
                max= prices[i];
            }
            // 2. calculate current profit;
            int profit = max - prices[i];
            // 3. update right dp array.
            right[i] = Math.max(right[i+1], profit);
        }

        int maxProfit = 0;
        for(int i = 0; i<n; i++){
            maxProfit = Math.max(left[i]+right[i], maxProfit);
        }

        return maxProfit;
    }
}