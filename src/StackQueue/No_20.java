package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.20 有效的括号 (easy)
 */
public class No_20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            }else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }

        return stack.isEmpty();
//        for (char ch : s.toCharArray()) {
//            if (ch == ')') {
//                if ((stack.isEmpty() || stack.pop() != '(')) return false;
//            } else if (ch == '}') {
//                if ((stack.isEmpty() || stack.pop() != '{')) return false;
//            } else if (ch == ']') {
//                if ((stack.isEmpty() || stack.pop() != '[')) return false;
//            } else {
//                stack.push(ch);
//            }
//        }
//
//        return stack.isEmpty();
    }
}
