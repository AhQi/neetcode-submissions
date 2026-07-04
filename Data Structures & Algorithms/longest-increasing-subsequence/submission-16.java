class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int index, int last) {
        if (index == nums.length) {
            return 0;
        }

        if (memo[last+1][index] != -1) {
            return memo[last+1][index];
        }

        int res = helper(nums, index+1, last);

        if (last == -1 || nums[index] > nums[last]) {
            res = Math.max(res, 1+helper(nums, index+1, index));
        }

        memo[last+1][index] = res;
        return res;
    }
}
