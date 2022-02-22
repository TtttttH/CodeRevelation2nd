package doublePoint;

/**
 * No.26 删除有序数组中的重复项 (easy)
 */
public class No_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }

        return i;
    }
}
