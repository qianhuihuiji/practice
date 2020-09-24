package Leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 相交链表
 */
public class Question155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }
}

class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
