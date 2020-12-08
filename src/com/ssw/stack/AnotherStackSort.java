package com.ssw.stack;

import java.util.Stack;

/**
 * 用一个栈给另一个栈排序，从栈顶到栈底从大到小排序
 *
 * 实现方法：
 *  生成一个辅助栈help;
 *  stack栈弹出的元素记为cur;
 *  如果cur小于等于help的栈顶元素，直接压入help。
 *  如果cur大于help的栈顶元素，则先将help的元素逐个弹出压入stack,再将cur压入help栈。
 */
public class AnotherStackSort {

    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.empty()){
            int cur = stack.pop();
            while(!help.empty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.empty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(8);
        sortStack(stack);

        //导入到新的开发环境

    }

}
