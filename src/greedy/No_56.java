package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.56 合并区间(middle) 微软
 */
public class No_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                list.add(new int[] {left, right});
                left = interval[0];
                right = interval[1];
            } else right = Math.max(right, interval[1]);
        }
        list.add(new int[]{left, right});

        return list.toArray(new int[][]{});
    }
}
