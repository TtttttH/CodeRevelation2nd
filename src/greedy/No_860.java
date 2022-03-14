package greedy;

/**
 * No.860 柠檬水找零 (easy)
 */
public class No_860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five ++;
                continue;
            }
            if (bill == 10) {
                if (five == 0) return false;
                five --;
                ten ++;
                continue;
            }

            if (bill == 20) {
                if (five == 0) return false;
                if (five < 3 && ten < 1) return false;
                if (ten > 0) {
                    ten --;
                    five --;
                } else {
                    five -= 3;
                }
            }
        }
        return true;
    }
}
