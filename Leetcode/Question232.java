package Leetcode;

import java.util.Stack;

/**
 * [232] 用栈实现队列
 */
public class Question232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.pop();
        System.out.println(queue.empty()); // 返回 false
    }
}

class MyQueue {
    private int front;
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (inStack.isEmpty()) {
            front = x;
        }

        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (! inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (! outStack.isEmpty()) {
            return outStack.peek();
        }

        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}