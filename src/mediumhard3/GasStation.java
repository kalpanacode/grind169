// https://leetcode.com/problems/gas-station/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalTank += netGas;
            currentTank += netGas;

            // If tank is negative, reset start position and tank
            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }

        return totalTank >= 0 ? startingStation : -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};

        int startIndex = canCompleteCircuit(gas1, cost1);
        System.out.println("Starting gas station index: " + startIndex);  // Expected: 3
    }
}

