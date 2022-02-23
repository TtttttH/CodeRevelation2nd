package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.150 Evaluate Reverse Polish Notation(middle) 微软题
 */
public class No_150 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                stack.push(s);
                continue;
            }
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            switch (s) {
                case "+":
                    stack.push(String.valueOf(num1 + num2));
                    break;
                case "-":
                    stack.push(String.valueOf(num2 - num1));
                    break;
                case "*":
                    stack.push(String.valueOf(num2 * num1));
                    break;
                default:
                    stack.push(String.valueOf(num2 / num1));
                    break;
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
