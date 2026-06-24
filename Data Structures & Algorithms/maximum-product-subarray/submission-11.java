class Solution {
    // public int maxProduct(int[] nums) {
    //     int curMin = 1, curMax = 1;
    //     int res = nums[0];

    //     for (int i = 0; i < nums.length; i++) {
    //         int tmp = curMin*nums[i];
    //         curMin = Math.min(nums[i], Math.min(tmp, nums[i] * curMax));
    //         curMax = Math.max(nums[i], Math.max(nums[i] * curMax, tmp));

    //         res = Math.max(res, curMax);
    //     }

    //     return res;
    // }

    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length-i-1] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
