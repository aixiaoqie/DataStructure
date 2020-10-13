package com.ssw.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *  pop push getMin操作时间复杂度为O(1)
 *  可以使用现成的栈结构
 */
public class MyStack {
    private Stack stackData;
    private Stack stackMin;

    public MyStack(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getMin(){
        if(stackMin.empty()){
            throw new RuntimeException("stack is empty");
        }
        return (int) this.stackMin.peek();
    }
    public void push(int newNum){
        if(this.stackMin.empty()){
            this.stackMin.push(newNum);
        }else if(newNum < (int)this.stackMin.peek()){
            this.stackMin.push(newNum);
        }else {
            int newValue = (int) this.stackMin.peek();
            this.stackMin.push(newValue);
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        if(this.stackMin.empty()){
            throw new RuntimeException("stack is empty");
        }
        this.stackMin.pop();
        return (int) this.stackData.pop();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(4);
        myStack.push(7);
        myStack.push(5);
        System.out.println(myStack.getMin());
        System.out.println(myStack.pop());
        myStack.push(9);

        System.out.println(myStack.getMin());
        System.out.println(myStack.pop());
    }
}
