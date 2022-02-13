package array;

import java.util.Arrays;

/**
 * No.27 移除元素(easy)
 */
public class No_27 {
    public int removeElements(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }

        return count;
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int count = 0;
//        for (int i = 0; i < nums.length; i ++) {
//            if (nums[i] == val) {
//                nums[i] = 51;
//                count ++;
//            }
//        }
//
//        Arrays.sort(nums);
//        return nums.length - count;
    }
}
