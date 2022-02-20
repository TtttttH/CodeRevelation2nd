package String;

/**
 * No.6 Z字形变换 (middle) 按行推导找规律解法
 */
public class No_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int loop = 2 * numRows - 2;
        for (int i = 0; i < numRows; i ++) {
            for (int k = 0; k + i < s.length(); k += loop) {
                sb.append(s.charAt(k + i));
                if (i != 0 && i != numRows - 1 && k + loop - i < s.length()) { //注意这里防溢出
                    sb.append(s.charAt(k + loop - i));
                }
            }
        }

        return sb.toString();
    }
}
