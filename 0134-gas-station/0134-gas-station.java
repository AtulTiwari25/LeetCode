class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int g : gas){
            totalGas += g;
        }

        for(int c : cost){
            totalCost += c;
        }
        if(totalCost > totalGas){
            return -1;
        }

        int idx = 0;
        int currentGas = 0;
        for(int i=0; i<gas.length; i++){
            currentGas += gas[i] - cost[i];
            if(currentGas < 0){
                currentGas = 0;
                idx = i+1;
            }
        }

        return idx;
    }
}


