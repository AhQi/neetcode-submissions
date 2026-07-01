class Solution {
    Map<Integer, Integer> map;
    public int rob(int[] nums) {
        map = new HashMap<>();
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return helper(nums, 0);
    }

    private int helper(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (nums.length - 1 == index) {
            return nums[index];
        }
        if (map.get(index) != null) {
            return map.get(index);
        }
        map.put(index, Math.max(nums[index] + helper(nums, index+2), helper(nums, index+1)));

        return map.get(index);
    }




    
}
