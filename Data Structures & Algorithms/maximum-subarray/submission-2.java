class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum - min);
            min = Math.min(min, sum);
        }

        return ans;
    }
}
