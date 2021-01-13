package com.ssw.arrays.topic.structure;

/**
 * 使用数组结构实现大小固定的栈和队列
 * <p>
 * 数组结构实现大小固定的队列
 */
public class ArrayToQueue {

    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayToQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("the init size is less than zero");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public void push(int num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        size++;
        arr[end] = num;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[tmp];
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

    public static void main(String[] args) {
        ArrayToQueue queue = new ArrayToQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }

}
