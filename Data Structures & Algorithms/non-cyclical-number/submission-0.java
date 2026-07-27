class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (true) {
            int sum = squareSum(n);
            if (visited.contains(sum)) {
                return false;
            }
            if (sum == 1) {
                break;
            }
            visited.add(sum);
            n = sum;
        }
        return true;
    }

    private int squareSum(int n) {
        int tmp = 0;

        while (n > 0) {
            tmp += (n%10) * (n%10);
            n /= 10;
        }
        return tmp;
    }
}
