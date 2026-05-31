class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length+1];
        

        for (int i = 0; i < sum.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
                continue;
            }
            if (i == 1) {
                sum[i] = Math.max(nums[i-1], nums[i]);
                continue;
            }
            if (i < nums.length) {
                sum[i] = Math.max(
                    sum[i - 2] + nums[i],
                    sum[i-1]
                );
            }
            
        }

        return nums.length <= 2? Math.max(nums[0], nums[1]):
        Math.max(sum[sum.length - 2], sum[sum.length - 1]);
    }
}
