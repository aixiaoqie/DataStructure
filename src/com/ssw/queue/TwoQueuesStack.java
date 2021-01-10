package com.ssw.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈结构，实现栈的基本操作push pop peek
 */
public class TwoQueuesStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public void push(int num) {
        queue.add(num);
    }

    /**
     * 实现栈的pop(),弹出栈顶数
     *
     * @return
     */
    public Integer pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    public Integer peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    //交换两个queue的指针
    public void swap() {
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
    }

    public static void main(String[] args) {
        TwoQueuesStack stack = new TwoQueuesStack();
        stack.push(1);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}
