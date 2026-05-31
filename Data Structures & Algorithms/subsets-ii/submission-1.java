class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        return traverse(nums, new ArrayList<>(), 0);
    }

    private List<List<Integer>> traverse(int[] nums,  List<Integer> combination, int cur) {
        final List<List<Integer>> results = new ArrayList<>();

        if (cur == nums.length) {
            results.add(new ArrayList<>(combination));
            return results;
        }

        combination.add(nums[cur]);
        results.addAll(traverse(nums, combination, cur+1));
        combination.remove(combination.size() - 1);

        while (cur + 1 < nums.length && nums[cur+1] == nums[cur]) {
            cur++;
        }
        results.addAll(traverse(nums, combination, cur+1));

        return results;
    }
}
