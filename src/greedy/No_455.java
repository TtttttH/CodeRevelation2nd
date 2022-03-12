package greedy;

import java.util.Arrays;

/**
 * No.455 分发饼干 (easy) O(m*log m + n*log n)
 */
public class No_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, cnt = 0;
        for (int i : s) {
            if (j == g.length) break;
            if (g[j] < i) {
                j ++;
                cnt ++;
            }
        }

        return cnt;
    }
}
