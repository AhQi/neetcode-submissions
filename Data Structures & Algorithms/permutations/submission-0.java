class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return traverse(nums, new ArrayList<>(), 0, new boolean[nums.length]);
    }

    private List<List<Integer>> traverse(int[] nums,  List<Integer> permutation, int cur, boolean[] pick) {
        final List<List<Integer>> result = new ArrayList<>();
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return result;
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (pick[i]) {
                continue;
            }
            permutation.add(nums[i]);
            pick[i] = true;
            result.addAll(traverse(nums, permutation, i, pick));
            pick[i] = false;
            permutation.remove(permutation.size() - 1);
        }
        
        return result;
    }
}
