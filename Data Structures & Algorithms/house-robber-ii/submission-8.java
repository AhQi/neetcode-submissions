class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            return  nums[0];
        }
      int[] first = Arrays.copyOfRange(nums, 1, nums.length);
      int[] second = Arrays.copyOfRange(nums, 0, nums.length - 1);

      return Math.max(robHouse(first), robHouse(second)); 
    }

    private int robHouse(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            return  nums[0];
        }
        
        
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }

        return b;
    }
}
