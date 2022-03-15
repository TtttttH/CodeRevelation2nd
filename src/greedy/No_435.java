package greedy;

import java.util.Arrays;

/**
 * No.435 无重叠区间(middle) 微软
 */
public class No_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int cnt = 0, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] < right) {
                cnt ++;
                right = Math.min(right, intervals[i][1]);
            } else {
                right = intervals[i][1];
            }
        }
        return cnt;
    }
}
