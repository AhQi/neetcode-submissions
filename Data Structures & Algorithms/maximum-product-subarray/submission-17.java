class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int res = nums[0];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            res = Math.max(res, prefix);
        }

        for (int i = n-1; i >= 0; i--) {
            suffix = (suffix == 0 ? 1 : suffix) * nums[i];
            res = Math.max(res, suffix);
        }

        return res;
    }
}
