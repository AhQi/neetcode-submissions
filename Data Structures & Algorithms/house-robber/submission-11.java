class Solution {
    Map<Integer, Integer> map;
    public int rob(int[] nums) {
        map = new HashMap<>();
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

    private int helper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (nums.length - 1 == index) {
            return nums[index];
        }
        if (map.get(index) != null) {
            return map.get(index);
        }
        map.put(index, Math.max(nums[index] + helper(nums, index+2), helper(nums, index+1)));

        return map.get(index);
    }




    
}
