class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] nums = null;

        for (int[] triplet : triplets) {
            boolean shouldRemove = false;
            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] > target[i]) {
                    shouldRemove = true;
                    break;
                }
            }

            if (!shouldRemove) {
                if (nums == null) {
                    nums = triplet;
                } else {
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = Math.max(nums[i], triplet[i]);
                    }
                }
                
            }
        }

        return Arrays.equals(target, nums);
    }
}
