class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            res = Math.max(res, prefix);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffix = nums[i] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, suffix);
        }

        return res;
    }
}
