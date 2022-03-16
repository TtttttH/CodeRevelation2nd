package dp;

/**
 * No.509 斐波那契数(easy)
 * 递归O(2^n)
 * 迭代O(n)
 */
public class No_509 {
    public int fib(int n) {
//        if (n == 0 || n == 1) return n;
//        return fib(n - 1) + fib(n - 2);
        if (n == 0 || n == 1) return n;
        int dp1 = 0, dp2 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i ++) {
            temp = dp2;
            dp2 = dp2 + dp1;
            dp1 = temp;
        }

        return dp2;
    }
}
