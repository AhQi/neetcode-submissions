class Solution {
    // public int maxProduct(int[] nums) {
    //     int prefix = 1;
    //     int suffix = 1;
    //     int res = nums[0];

    //     for (int i = 0; i < nums.length; i++) {
    //         prefix = nums[i] * (prefix == 0 ? 1 : prefix);
    //         res = Math.max(res, prefix);
    //     }

    //     for (int i = nums.length - 1; i >= 0; i--) {
    //         suffix = nums[i] * (suffix == 0 ? 1 : suffix);
    //         res = Math.max(res, suffix);
    //     }

    //     return res;
    // }

    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = curMax * nums[i];
            curMax = Math.max(nums[i], Math.max(tmp, curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(tmp, curMin * nums[i]));
            res = Math.max(res, Math.max(curMax, curMin));
        }

        return res;
    }
}
