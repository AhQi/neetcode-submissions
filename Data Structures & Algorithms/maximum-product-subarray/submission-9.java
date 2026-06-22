class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1, postfix = 1;
        int res = nums[0];
        int n = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1:prefix);
            postfix = nums[n-i] * (postfix == 0 ? 1: postfix);
            res = Math.max(res, Math.max(prefix, postfix));
        }

        return res;
    }
}
