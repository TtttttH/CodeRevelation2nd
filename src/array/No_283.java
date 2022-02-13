package array;

/**
 * No.283 移动零(easy)
 */
public class No_283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if (nums[fast] != 0) {
                nums[slow ++] = nums[fast];
            }
        }

        while (slow < nums.length) {
            nums[slow ++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 0, 12};
        No_283 test = new No_283();
        test.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}
