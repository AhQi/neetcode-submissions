class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preProducts = new int[nums.length];
        int[] postProducts = new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preProducts[i] = 1;
                postProducts[nums.length - 1] = 1;
            } else {
                preProducts[i] = preProducts[i-1] * nums[i-1];
                postProducts[nums.length - 1 - i] = postProducts[nums.length - i] * nums[nums.length - i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = preProducts[i] * postProducts[i];
        }

        return res;
    }
}  
