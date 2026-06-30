class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        memo = new int[5001][5001];
        for (int num : nums) {
            sum += num;
        }
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        if (sum % 2 != 0) {
            return false;
        }
        return helper(nums, -1, sum/2);
    }

    private boolean helper(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (memo[index+1][sum] != -1) {
            return memo[index+1][sum] == 1 ? true : false;
        }
        for (int i = index+1; i < nums.length; i++) {
            if (sum - nums[i] >= 0 && helper(nums, i, sum - nums[i])) {
                memo[index+1][sum] = 1;
                return true;
            }
            if (helper(nums, i, sum)) {
                memo[index+1][sum] = 1;
                return true;
            }
        }

        memo[index+1][sum] = 0;
        return false;
    }
}
