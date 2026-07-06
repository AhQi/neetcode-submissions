class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return helper(nums, 0, sum/2);
    }

    private boolean helper(int[] nums, int index, int target) {
        if (target < 0 || index == nums.length) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        boolean res = helper(nums, index + 1, target - nums[index])
            || helper(nums, index + 1, target);

        return res;

    }
}
