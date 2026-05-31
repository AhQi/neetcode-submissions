class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return traverse(candidates, 0, new ArrayList<>(), target);
    }

    private List<List<Integer>> traverse(int[] candidates, int cur, List<Integer> combination, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return result;
        }

        if (cur >= candidates.length || candidates[cur] > target) {
            return result;
        }

        // pick
        combination.add(candidates[cur]);
        result.addAll(traverse(candidates, cur + 1, combination, target - candidates[cur]));
        combination.remove(combination.size() - 1);

        // not pick
        while (cur + 1 < candidates.length && candidates[cur+1] == candidates[cur]) {
            cur++;
        }
        result.addAll(traverse(candidates, cur + 1, combination, target));

        return result;
    }
}
