class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        // if sum of gas greater than sum of cost, it means there is one solution existing.
        int start = 0;
        int curTank = 0;

        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                curTank = 0;
                start = i+1;
            }

        }

        return start;

    }
}

 
