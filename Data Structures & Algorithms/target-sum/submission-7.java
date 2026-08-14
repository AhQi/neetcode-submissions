class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = target + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ans = dfs(nums, target + nums[index], index+1);
        ans += dfs(nums, target - nums[index], index+1);
        memo.put(key, ans);
        return ans;
    }
}
