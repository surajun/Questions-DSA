class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas =0;
        int totalcost =0;
        // uniques solution
        int start = 0; 
        int currgas = 0;
        for (int i = 0; i < gas.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];
            currgas += gas[i] - cost[i];
            if ( currgas < 0){
                start = i+1;
                currgas = 0;
            }
        }
        if ( totalgas < totalcost){
            return -1;
        }
        return start;
    }
}