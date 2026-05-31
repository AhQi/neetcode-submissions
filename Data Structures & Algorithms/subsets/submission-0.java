class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return traverse(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> traverse(int[] nums, int cur, List<Integer> subset) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(subset));
        for (int i = cur; i < nums.length; i ++) {
            subset.add(nums[i]);
            //visited.put(i, true);
            result.addAll(traverse(nums, i+1, new ArrayList<>(subset)));
            //visited.put(i, false);
            subset.remove(subset.size()-1);
        }

        return result;
    }
}
