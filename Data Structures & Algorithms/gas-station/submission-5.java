class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if sum of gas greater than sum of cost, it means there is one solution existing.
        int sumOfGas = 0;
        int sumOfCost = 0;
        int start = -1;
        int curTank = 0;

        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        for (int i = 0; i < gas.length; i++) {
            sumOfGas += gas[i];
            sumOfCost += cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                curTank = 0;
                start = -1;
            }
            if (curTank > 0 && start == -1) {
                start = i;
            }
        }

        return sumOfGas >= sumOfCost ? start : -1;

    }
}

 
