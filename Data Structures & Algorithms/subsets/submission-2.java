class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return traverse(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> traverse(int[] nums, int cur, List<Integer> subset) {
        List<List<Integer>> result = new ArrayList<>();
        if (cur == nums.length) {
           result.add(new ArrayList<>(subset));
           return result;
        }
        
        subset.add(nums[cur]);
        //visited.put(i, true);
        result.addAll(traverse(nums, cur+1, new ArrayList<>(subset)));
        //visited.put(i, false);
        subset.remove(subset.size()-1);
        result.addAll(traverse(nums, cur+1, new ArrayList<>(subset)));

        return result;
    }
}
