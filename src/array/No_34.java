package array;

/**
 * No.34 在排序数组中查找元素的第一个和最后一个位置
 */
public class No_34 {
    public int[] searchRange(int[] nums, int target) {
        int leftEdge = getLeftEdge(nums, target);
        int rightEdge = getRightEdge(nums, target);

        if (leftEdge == -2 || rightEdge == -2) {
            return new int[]{-1, -1};
        }

        if (rightEdge - leftEdge > 1) {
            return new int[]{leftEdge + 1, rightEdge - 1};
        }

        return new int[]{-1, -1};
    }

    private int getLeftEdge(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftEdge = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                leftEdge = right;
            } else {
                left = mid + 1;
            }
        }

        return leftEdge;
    }

    private int getRightEdge(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int rightEdge = -2;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                rightEdge = left;
            } else {
                right = mid - 1;
            }
        }

        return rightEdge;
    }
}
