package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * No.454 四数相加II (middle)
 */
public class No_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumOneCount = new HashMap<>();

        int temp = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                temp = num1 + num2;
                sumOneCount.put(temp, sumOneCount.getOrDefault(temp, 0) + 1);
            }
        }

        int result = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                temp = num3 + num4;
                if (sumOneCount.containsKey(-temp)) {
                    result += sumOneCount.get(-temp);
                }
            }
        }

        return result;
    }
}
