package greedy;

/**
 * No.45 跳跃游戏II (middle)
 */
public class No_45 {
    public int jump(int[] nums) {
        int step = 0;
        if (nums.length == 1) return 0;
        int range = 0, nextRange = 0;
        for (int i = 0; i <= range; i ++) {
            nextRange = Math.max(nextRange, nums[i] + i);
            if (nextRange >= nums.length - 1) {
                step ++;
                break;
            }
            if (i == range) {
                range = nextRange;
                step ++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        No_45 test = new No_45();
        System.out.println(test.jump(nums));
    }
}
