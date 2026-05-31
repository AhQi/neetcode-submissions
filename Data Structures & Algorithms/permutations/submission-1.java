class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return traverse(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private List<List<Integer>> traverse(int[] nums,  List<Integer> permutation, boolean[] pick) {
        final List<List<Integer>> result = new ArrayList<>();
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return result;
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                permutation.add(nums[i]);
                result.addAll(traverse(nums, permutation, pick));
                permutation.remove(permutation.size() - 1);
                pick[i] = false;
            }
        }
        return result;
    }
}
