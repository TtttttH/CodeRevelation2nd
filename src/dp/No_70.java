package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * No.70 爬楼梯(easy) 微软
 */
public class No_70 {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 3; i <= n; i ++) {
            int temp = dp2;
            dp2 =  dp1 + dp2;
            dp1 = temp;
        }

        return dp2;
    }

    //进阶:不能爬到7或者7的倍数
    public int climbAvoid7(int n) {
        if (n % 7 == 0) return 0;
        if (n < 3) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 3; i <= n; i ++) {
            if (i % 7 != 0) {
                int temp = dp2;
                dp2 = dp1 + dp2;
                dp1 = temp;
            } else {
                dp1 = dp2;
                dp2 = 0;
            }
        }

        return dp2;
    }
    //进阶:求所有路径
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> climbPath(int n) {
        getPath(0, n);
        System.out.println("res length:"+ res.size());
        return res;
    }

    private void getPath(int cur, int n) {
        if (cur > n) return;
        if (cur == n) {
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(1);
        getPath(cur + 1, n);
        path.remove(path.size() - 1);
        path.add(2);
        getPath(cur + 2, n);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        No_70 test = new No_70();
        test.climbPath(5);
    }
}
