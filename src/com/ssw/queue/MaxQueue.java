package com.ssw.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 其实本质上是一个求滑动窗口最大值的问题。这个队列可以看成是一个滑动窗口，入队就是将窗口的右边界右移，出队就是将窗口的左边界右移。
 * <p>
 * 既然是求解滑动窗口的最大值问题，那就变成了模板题，直接套单调队列模板即可。
 */
public class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> help;


    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.pollFirst();
        if (val == help.peekFirst()) {
            help.pollFirst();
        }
        return val;
    }
}
