package monotonous_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.739 每日温度(middle) 微软
 */
public class No_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        Deque<Integer> idxStack = new LinkedList<>();
        idxStack.push(0);
        for (int i = 1; i < n; i++) {
            while (!idxStack.isEmpty() && temperatures[idxStack.peek()] < temperatures[i]) {
                int idx = idxStack.pop();
                ans[idx] = i - idx;
            }

            idxStack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temper = {23, 24, 27, 22, 19, 18, 29, 20};
        No_739 test = new No_739();
        int[] ans = test.dailyTemperatures(temper);
        for (int an : ans) System.out.println(an);

    }
}
