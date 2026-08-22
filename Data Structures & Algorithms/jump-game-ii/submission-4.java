class Solution {
    Integer[] memo;
    public int jump(int[] nums) {
        memo = new Integer[nums.length+1];
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        int ans = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= nums[index]; i++) {
            int next = index + i;
            if (next >= nums.length) {
                break;
            }
            ans = Math.min(ans, 1 + dfs(nums, next));
        }

        return memo[index] = ans;
    }
}
