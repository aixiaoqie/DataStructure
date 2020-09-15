package com.ssw.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 构造数组的maxTree函数
 *  定义二叉树节点如下
 *    class Node {
 *         public Node left;
 *         public Node right;
 *         public int value;
 *         public Node(int data){
 *             this.value = data;
 *         }
 *     }
 *
 *     一个数组的MaxTree函数如下：
 *     1. 数组没有重复元素。
 *     2.MaxTree是一棵二叉树，数组的每一个值对应二叉树节点。
 *     3.包括MaxTree所有树在内的且在其中的子树上，最大的节点都是树的头结点。
 *
 *     给定一个没有重复数组的arr,写出生成这个数组的MaxTree函数，要求数组长度为N，时间复杂度O(N),额外空间复杂度O(N).
 *
 *
 *     遵循以下原则建立树
 *     1. 每一棵树的父节点是左面第一个比他大的数与右面第一个比他大的数中较小的那个；
 *     2. 如果一个数左面没有比他最大的，而且右面也没有比他更大的。则这个数就是数组的最大值，为MaxTree的头节点。
 *
 */
public class GenerateMaxTree {

    class Node {
        public Node left;
        public Node right;
        public int value;
        public Node(int data){
            this.value = data;
        }
    }

    public Node getMaxTree(int []arr){
        Node []nArr = new Node[arr.length];
        for(int i=0; i!= arr.length; i++){
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        Map<Node,Node> lBigMap = new HashMap<Node,Node>();
        Map<Node,Node> rBigMap = new HashMap<Node,Node>();
        for(int i=0; i!=nArr.length; i++){
            Node curNode = nArr[i];
            while((!stack.empty()) && stack.peek().value<curNode.value){
                popStackToMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.empty()){
            popStackToMap(stack,lBigMap);
        }
        for(int i= nArr.length;i!=0;i--){
            Node curNode = nArr[i];
            while((!stack.empty()) && stack.peek().value<curNode.value){
                popStackToMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.empty()){
            popStackToMap(stack,rBigMap);
        }
        Node head = null;
        for(int i=0;i!=nArr.length;i++){
            Node curNode = nArr[i];
            Node lBigNode = lBigMap.get(curNode);
            Node rBigNode = rBigMap.get(curNode);
            if(lBigNode == null && rBigNode==null){
                head = curNode;
            }else if(lBigNode == null){
                if(rBigNode.left == null){
                    rBigNode.left = curNode;
                }else{
                    rBigNode.right = curNode;
                }
            }else if(rBigNode == null){
                if(lBigNode.left == null){
                    lBigNode.left = curNode;
                }else{
                    lBigNode.right = curNode;
                }
            }else {
                Node parent = lBigNode.value < rBigNode.value ? lBigNode : rBigNode;
                if(parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }
        }

        return head;

    }

    private void popStackToMap(Stack<Node> stack, Map<Node, Node> map) {
        Node popNode = stack.pop();
        if(stack.empty()){
            map.put(popNode,null);
        }else{
            map.put(popNode,stack.peek());
        }
    }

}
