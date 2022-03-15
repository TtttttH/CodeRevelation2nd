package greedy;

import java.util.Arrays;

/**
 * No.738 单调递增的数字(middle)
 */
public class No_738 {
    public int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int startNine = nums.length;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] < nums[i - 1]) {
                nums[i - 1] --;
                startNine = i;
            }
        }

        for (int i = startNine; i < nums.length; i ++) {
            nums[i] = '9';
        }
        return Integer.parseInt(new String(nums));
    }

    public static void main(String[] args) {
        int n = 10;
        No_738 test = new No_738();
        System.out.println(test.monotoneIncreasingDigits(n));
    }
}
