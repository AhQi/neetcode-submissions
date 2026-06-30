class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        memo = new Boolean[nums.length+1][sum/2+1];

        if (sum % 2 != 0) {
            return false;
        }
        return helper(nums, 0, sum/2);
    }

    private boolean helper(int[] nums, int index, int sum) {
        if (index == nums.length) {
            return sum == 0;
        }
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }

        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        memo[index][sum] = helper(nums, index + 1, sum - nums[index])
        || helper(nums, index + 1, sum );

        return memo[index][sum];
    }
}
