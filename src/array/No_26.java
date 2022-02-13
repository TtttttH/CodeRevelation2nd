package array;

/**
 * No.26 删除有序数组中的重复项 (easy)
 */
public class No_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast ++) {
            if (nums[fast] != nums[slow]) {
                slow ++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
