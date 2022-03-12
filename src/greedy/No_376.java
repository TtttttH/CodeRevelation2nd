package greedy;

/**
 * No.376 摆动序列(middle)
 */
public class No_376 {
    public int wiggleMaxLength(int[] nums) {
        int cnt = 1, curDiff = 0, preDiff = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            curDiff = nums[i + 1] - nums[i];
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) cnt ++;
            preDiff = curDiff;
        }

        return cnt;
    }
}
