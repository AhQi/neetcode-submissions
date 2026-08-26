class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumOfGas = 0;
        int sumOfCost = 0;

        for (int i = 0; i < gas.length; i++) {
            sumOfGas += gas[i];
            sumOfCost += cost[i];
        }

        if (sumOfCost > sumOfGas) {
            return -1;
        }

        int start = 0;
        int curTank = 0;

        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];

            if (curTank < 0) {
                start = i+1;
                curTank = 0;
            } 
        }

        return start;
        
    }
}
