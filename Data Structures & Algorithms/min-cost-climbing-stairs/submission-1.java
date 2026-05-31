class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Keep an array to track what's the minimum steps needed,
        // to reach to the specific floor.
        // minSteps: [0, 0] start from either 1th or 2nd floor, so min steps is 0
        // fn = min(f[n-1]+ cost[n-1], f[n-2] + cost[n-2])

        int[] minSteps = new int[cost.length+1];
        minSteps[0] = 0;
        minSteps[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            minSteps[i] = Math.min(cost[i-1]+minSteps[i-1],
            cost[i-2]+minSteps[i-2]);
        }

        return minSteps[cost.length];
    }
}
