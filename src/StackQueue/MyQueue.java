package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * No.232 用栈实现队列(easy)
 */
public class MyQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    public MyQueue() {
        this.stackIn = new ArrayDeque<>();
        this.stackOut = new ArrayDeque<>();
    }

    void push(int x) {
        stackIn.push(x);
    }

    int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.pop();
    }

    int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.peek();
    }

    boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}
