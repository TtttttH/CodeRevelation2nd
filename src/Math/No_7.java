package Math;

/**
 * No.7 整数翻转(middle)
 */
public class No_7 {
    public int reverse(int x) {
        boolean minus = x < 0;
        int ans = 0;
        while (x != 0) {
            int temp = x % 10;
            if (minus) { //x为负数
                if (ans < (Integer.MIN_VALUE - temp) / 10) return 0;
            } else if (ans > (Integer.MAX_VALUE - temp) / 10) return 0;

            ans = ans*10 + temp;
            x = x / 10;
        }

        return ans;
    }
}
