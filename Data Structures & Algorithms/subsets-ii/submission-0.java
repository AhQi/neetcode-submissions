class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        return traverse(nums, new ArrayList<>(), 0);
    }

    private List<List<Integer>> traverse(int[] nums,  List<Integer> combination, int cur) {
        final List<List<Integer>> result = new ArrayList<>();
        if (cur == nums.length) {
            result.add(new ArrayList<>(combination));
            return result;
        }
    

        combination.add(nums[cur]);
        result.addAll(traverse(nums, combination, cur+1));
        combination.remove(combination.size() - 1);

        while (cur + 1 < nums.length && nums[cur] == nums[cur+1]) {
            cur++;
        }
        result.addAll(traverse(nums, combination, cur+1));
        
        return result;
    }
}
