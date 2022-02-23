package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.1047 删除字符串中的所有相邻重复项 (easy)
 */
public class No_1047 {
    public String removeDuplicates(String s) {
        //优化:模拟栈
        int index = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            if (index >= 0 && chars[index] == chars[i]) {
                index --;
            } else {
                index ++;
                chars[index] = chars[i];
            }
        }

        return String.copyValueOf(chars,0, index + 1);
//        Deque<Character> stack = new ArrayDeque<>();
//        for (char ch : s.toCharArray()) {
//            if (!stack.isEmpty() && stack.peek() == ch) {
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//
//        return sb.reverse().toString();
    }
}
