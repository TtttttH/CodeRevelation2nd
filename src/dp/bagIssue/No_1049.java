package dp.bagIssue;

/**
 * No.1049 最后一块石头的重量II (middle)
 */
public class No_1049 {
    public int lastStoneWeightII(int[] stones) {
        //转化为求全部重量一半背包的最大承重值，然后左右背包求差
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int[] dp = new int[sum + 1];
        for (int stone : stones) {
            for (int i = target; i >=stone ; i --) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target]; //注意这里是sum -2 * dp[target] 不是sum - target - dp[target]
    }
}
