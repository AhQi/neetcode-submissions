class Solution {
    Integer memo[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] values = new int[n+2];
        memo = new Integer[n+2][n+2];
        values[0] = 1;
        values[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            values[i+1] = nums[i];
        }

        return dfs(values, 0, n+1);
    }

    private int dfs(int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int best = 0;

        for (int pivot = left+1; pivot < right; pivot++ ) {
            int coins = nums[left] * nums[pivot] * nums[right]
                + dfs(nums, left, pivot)
                + dfs(nums, pivot, right);

            best = Math.max(best, coins);
        }

        return memo[left][right]= best;
    }
}
