class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > max) {
                max = tmp;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (tmp * nums[j] > max) {
                    max = tmp * nums[j];
                }
                tmp *= nums[j];
            }
        }

        return max != Integer.MIN_VALUE ? max : 0;
    }
}
