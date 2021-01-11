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

    /**
     * 封装倒数据的方法
     * 需满足2个条件
     * 1.pop栈中有数据不能将push数据倒入
     * 2.push栈中倒数据都要倒完
     **/
    public void dao() {
        if (!stackPop.isEmpty()) {
            return;
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }

}
