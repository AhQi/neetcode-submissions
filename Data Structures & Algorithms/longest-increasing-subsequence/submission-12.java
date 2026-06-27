class Solution {
    int[][] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(nums, -1, 0);
    }

    private int helper(int[] nums, int last, int index) {
        if (index == nums.length) {
            return 0;
        }

        if (memo[last+1][index] != -1) {
            return memo[last+1][index];
        }
        int skip = helper(nums, last, index+1);
        int take = 0;
        if (last == -1 || nums[index] > nums[last]) {
            take = 1 + helper(nums, index, index+1);
        }
        memo[last+1][index] = Math.max(skip, take);
        return Math.max(skip, take);

    }
}
