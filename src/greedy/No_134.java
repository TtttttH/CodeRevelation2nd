package greedy;

/**
 * No.134 加油站(middle)
 */
public class No_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0, rest = 0, index = 0;
        for (int i = 0; i < gas.length; i ++) {
            rest = gas[i] - cost[i]; //该站的剩余油量
            curSum += rest;//当前起点情况下的剩余油量
            totalSum += rest;//总流程累计油量
            if (curSum < 0) {
                curSum = 0;
                index = i + 1;
            }
        }

        if (totalSum < 0) return -1;
        return index;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        No_134 test = new No_134();
        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
