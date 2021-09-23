package code;

public class P0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas >= totalCost) {
            for (int i = 0; i < gas.length; i++) {
                if (reachable(gas, cost, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean reachable(int[] gas, int[] cost, int start) {
        if (gas[start] < cost[start]) {
            return false;
        }
        int curr = gas[start] - cost[start];
        for (int i = (start+1)%gas.length; i != start; i = (i+1)% gas.length) {
            curr += gas[i] - cost[i];
            if (curr < 0) {
                return false;
            }
        }
        return true;
    }
}
