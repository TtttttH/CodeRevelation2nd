package array;

/**
 * No.209 长度最小的子数组 (middle)
 */
public class No_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int count = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            count ++;
            while (sum >= target) {
                sum -= nums[start ++];
                result = Math.min(result, count);
                count --;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        No_209 test = new No_209();
        System.out.println(test.minSubArrayLen(target, nums));
    }
}
