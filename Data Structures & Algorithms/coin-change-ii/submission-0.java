class Solution {
    Integer[][] memo;
    public int change(int amount, int[] coins) {
        memo = new Integer[amount + 1][coins.length];
        Set<Integer> coinSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            coinSet.add(coin);
            min = Math.min(min, coin);
        }

        return dfs(amount, coins, min, 0);
        
    }

    private int dfs(int amount, int[] coins, int min, int index) {
        if (amount == 0) {
            return 1;
        }

        // if (coins.contains(amount)) {
        //     return 1;
        // }

        if (amount < min) {
            return 0;
        }
        if (memo[amount][index] != null) {
            return memo[amount][index];
        }

        int ans = 0;
        for (int i = index; i < coins.length; i++) {
            ans += dfs(amount - coins[i], coins, min, i);
        }
        memo[amount][index] = ans;

        return ans;
    }
}
