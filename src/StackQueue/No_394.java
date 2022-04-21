package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.394 字符串解码
 */
public class No_394 {
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        int num = 0;
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) { //ch is number
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(ans);
                ans = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = strStack.pop();
                int time = numStack.pop();
                for (int i = 0; i < time; i ++) {
                    temp.append(ans);
                }

                ans = temp;
            } else {
                ans.append(ch);
            }
        }


        return ans.toString();
    }
}
