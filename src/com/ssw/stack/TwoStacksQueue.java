package com.ssw.stack;

import java.util.Stack;

/**
 * 两个栈实现队列，实现队列的基本操作add,poll,peek
 */
public class TwoStacksQueue {
    private Stack stackPush;
    private Stack stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return (int) stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return (int) stackPop.peek();
    }

}
