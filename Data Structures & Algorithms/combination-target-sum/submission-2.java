class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //Arrays.sort(nums);

        return traverse(nums, new ArrayList<>(), 0, target);
    }

    private List<List<Integer>> traverse(int[] nums, List<Integer> combination, int curIdx, int target) {
        List<List<Integer>> result = new ArrayList<>(); 
        //System.out.println(combination);
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            //System.out.println(combination);
            return result;
        }

        if (target < 0 || curIdx == nums.length) {
            return result;
        }

        combination.add(nums[curIdx]);
        result.addAll(traverse(nums, combination, curIdx, target - nums[curIdx]));
        combination.remove(combination.size() - 1);
        result.addAll(traverse(nums, combination, curIdx+1, target));

        return result;
    }
}
