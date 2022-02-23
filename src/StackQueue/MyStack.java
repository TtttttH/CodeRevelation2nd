package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.225 用队列实现栈
 */
public class MyStack {
    Deque<Integer> queueStore;
    Deque<Integer> queueSupport;

    public MyStack() {
        this.queueStore = new ArrayDeque<>();
        this.queueSupport = new ArrayDeque<>();
    }

    void push(int x) {
        Deque<Integer> temp;
        queueSupport.offer(x);
        while (!queueStore.isEmpty()) {
            queueSupport.offer(queueStore.poll());
        }

        temp = queueSupport;
        queueSupport = queueStore;
        queueStore = temp;
    }

    int pop() {
        return queueStore.poll();
    }

    int top() {
        return queueStore.peek();
    }

    boolean empty() {
        return queueStore.isEmpty();
    }
}

