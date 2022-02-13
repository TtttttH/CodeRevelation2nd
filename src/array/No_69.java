package array;

/**
 * No.69 X的平方根
 */
public class No_69 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int x = 2;
        No_69 test = new No_69();
        System.out.println(test.mySqrt(x));
    }
}
