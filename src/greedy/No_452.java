package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No.452 用最少数量的箭引爆气球 (middle)
 */
public class No_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int cnt = 1, right = points[0][1];
        for (int i = 1; i < points.length; i ++) {
            if (points[i][0] <= right) {
                right = Math.min(points[i][1], right);
            } else {
                cnt ++;
                right = points[i][1];
            }
        }

        return cnt;

    }
}
