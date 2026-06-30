class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(nums, i));
        }
        return ans;
    }

    private int helper(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int tmp = 1;
        for (int i = index+1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                tmp = Math.max(tmp, 1 + helper(nums, i));
            }
        }
        dp[index] = tmp;
        return tmp;
    }
}
