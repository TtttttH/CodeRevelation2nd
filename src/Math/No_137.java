package Math;

/**
 * No.137 只出现一次的数字II (middle)
 * Microsoft
 */
public class No_137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i ++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }

            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}
