package doublePoint;

/**
 * No.977 有序数组的平方 (easy)
 */
public class No_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[i --] = nums[left] * nums[left];
                left ++;
            } else {
                result[i --] = nums[right] * nums[right];
                right --;
            }
        }

        return result;
    }
}
