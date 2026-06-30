class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int [] c : dp) {
            Arrays.fill(c, -1);
        }

        return helper(nums, -1, 0);
    }

    private int helper(int[] nums, int prev, int index) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[prev+1][index] != -1) {
            return dp[prev+1][index];
        }

        int tmp = 0;
        if(prev == -1 || nums[index] > nums[prev]) {
            tmp = 1 + helper(nums, index, index+1);
        }
        dp[prev+1][index] = Math.max(tmp, helper(nums, prev, index+1));
        return dp[prev+1][index];
    }
}
