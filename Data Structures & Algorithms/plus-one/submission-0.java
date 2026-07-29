class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> res = new LinkedList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            if (digits[i] > 9) {
                carry = 1;
                digits[i] -= 10;
            }
            res.addFirst(digits[i]);
        }
        if (carry == 1) {
            res.addFirst(1);
        }
        return res.stream()
                                  .mapToInt(Integer::intValue)
                                  .toArray();
    }
}
