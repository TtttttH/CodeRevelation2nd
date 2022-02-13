package array;

/**
 * No.367 有效的完全平方数
 */
public class No_367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < num / mid) {
                left = mid + 1;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                return mid * mid == num;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int num = 5;
//        int num = 6;
        int num = 16;

        No_367 test = new No_367();
        System.out.println(test.isPerfectSquare(num));
    }
}
