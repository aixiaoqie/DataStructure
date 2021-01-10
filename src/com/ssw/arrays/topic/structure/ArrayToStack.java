package com.ssw.arrays.topic.structure;

/**
 * 使用数组结构实现大小固定的栈和队列
 * <p>
 * 使用数组结构实现大小固定的栈
 */
public class ArrayToStack {
    private Integer[] arr;
    private Integer index;//用于记录数组位置

    //初始化
    public ArrayToStack(Integer initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("the init size is less than zero");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public void push(Integer num) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("the stack is full");
        }
        arr[index++] = num;
    }

    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        return arr[--index];
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }


}
