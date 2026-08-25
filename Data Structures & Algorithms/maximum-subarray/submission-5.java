class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int min = 0;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;

            ans = Math.max(ans, sum - min);
            min = Math.min(min, sum);
        }

        return ans;
    }
}
