class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int i, int canBuy) {
        if (i >= prices.length) {
            return 0;
        }
        if (i < prices.length && memo[i][canBuy] != -1) {
            return memo[i][canBuy];
        }

        int result = dfs(prices, i+1, canBuy);
        // hold stock

        if (canBuy == 1) {
            result = Math.max(result, dfs(prices, i+1, 0) - prices[i]);
        } else {
            result = Math.max(result,
                dfs(prices, i+2, 1) + prices[i]);
        }
        

        memo[i][canBuy] = result;
        return result;
    }
}
