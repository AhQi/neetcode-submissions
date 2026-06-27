class Solution {
    Map<List<Integer>, Integer> map = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        return helper(nums, -1001, 0);
    }

    private int helper(int[] nums, int last, int index) {
        if (index == nums.length) {
            return 0;
        }

        if (map.get(List.of(last, index)) != null) {
            return map.get(List.of(last, index));
        }
        int skip = helper(nums, last, index+1);
        int take = 0;
        if (nums[index] > last) {
            take = 1 + helper(nums, nums[index], index+1);
        }
        map.put(List.of(last, index), Math.max(skip, take));
        return Math.max(skip, take);

    }
}
