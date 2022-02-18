package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * No.349 两个数组的交集(easy)
 */
public class No_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (int i : result) {
            res[index ++] = i;
        }

        return res;
    }
}
