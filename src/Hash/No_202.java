package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * No.202 快乐数 (easy)
 */
public class No_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n = n / 10;
            }

            n = next;
        }
        return n == 1;
    }
}
