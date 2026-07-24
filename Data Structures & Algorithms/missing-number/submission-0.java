class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = (1+(n))*(n)/2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return expectedSum-sum;
    }
}
