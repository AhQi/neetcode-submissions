class Solution {
    public int climbStairs(int n) {
    // f(n) = f(n-1) + f(n-2)
        int fn1 = 1;
        int fn2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = fn2 + fn1;
            fn1 = fn2;
            fn2 = tmp;
        }

        return n > 1 ? fn2 : fn1;

    }
}
