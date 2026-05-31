class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);

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

        if (target < nums[curIdx]) {
            return result;
        }

        for (int i = curIdx; i < nums.length; i++) {
            combination.add(nums[i]);
            result.addAll(traverse(nums, combination, i, target - nums[i]));
            combination.remove(combination.size() - 1);
        }

        return result;
    }
}
