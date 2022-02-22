package doublePoint;

/**
 * No.27 移除元素 easy
 */
public class No_27 {
    public int removeElements(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right --];
            } else {
                left ++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 2;
        No_27 test = new No_27();
        System.out.println(test.removeElements(nums, val));
    }
}
