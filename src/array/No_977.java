package array;

/**
 * No.977 有序数组的平方 (easy)
 */
public class No_977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (nums[i] * nums[i] < nums[j] *  nums[j]) {
                res[k --] = nums[j] * nums[j];
                j --;
            } else {
                res[k --] = nums[i] * nums[i];
                i ++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        No_977 test = new No_977();
        int[] res = test.sortedSquares(nums);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
}
