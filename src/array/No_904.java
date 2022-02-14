package array;

import java.util.HashMap;
import java.util.Map;

/**
 * No.904 Fruit Into Baskets(middle)
 * 2022.2.14
 */
public class No_904 {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int res = 0;
        int left = 0;
        Map<Integer, Integer> typeMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i ++) {
            typeMap.put(fruits[i], typeMap.getOrDefault(fruits[i], 0) + 1);
            while (typeMap.size() > 2) {
                typeMap.put(fruits[left], typeMap.get(fruits[left]) - 1);
                if (typeMap.get(fruits[left]) == 0) typeMap.remove(fruits[left]);
                left ++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,
                2,2,3,3};
        No_904 test = new No_904();
        System.out.println(test.totalFruit(fruits));
    }
}
