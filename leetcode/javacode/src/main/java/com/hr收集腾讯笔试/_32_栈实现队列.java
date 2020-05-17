package com.hr收集腾讯笔试;

import java.util.Stack;

public class _32_栈实现队列 {
    public static void main(String[] args) {

    }
}

/**
 *
 * https://www.jianshu.com/p/bfc09dc0e02f
 *
 *
 * 初始化两个栈S1和S2。
 * S1作为元素的存储空间，S2作为数据的临时缓冲区
 *
 * 入队时，将元素压入s1。
 * 出队时，判断s2是否为空，如不为空，则直接弹出顶元素；
 * 如为空，则将s1的元素逐个“倒入”s2，把最后一个元素弹出并出队。
 */
class StackQueue<T> {
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();
    public void enQueue(T e) {
        stack1.push(e);
    }

    public T deQueue() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        } else  {
            while (!stack1.isEmpty()) {
                T pop = stack1.pop();
                stack2.push(pop);
            }
            return stack2.pop();
        }
    }
}


