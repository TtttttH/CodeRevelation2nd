package array;

/**
 * No.35 搜索插入排序位置 (easy)
 */
public class No_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[mid] < target) {
            return mid + 1;
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,7,9};
        No_35 test = new No_35();
        System.out.println(test.searchInsert(nums, 2));
    }
}
