package array;

/**
 * No.704 二分查找 (easy)
 */
public class No_704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,3,5,6,7,8,10};
        No_704 test = new No_704();
        System.out.println(test.search(nums, 10));
    }
}
