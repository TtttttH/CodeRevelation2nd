package greedy;

/**
 * No.55 跳跃游戏 (middle)
 */
public class No_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int range = nums[0];
        for (int i = 1; i <= range; i ++) {
            range = Math.max(range, nums[i] + i);
            if (range >= nums.length - 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4};
        No_55 test = new No_55();
        System.out.println(test.canJump(nums));
    }
}
