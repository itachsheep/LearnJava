package structe_data.forth_stack_and_queue;

import java.util.Stack;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 16:31
 * Algorithm
 * structe_data
 */

public class StackX {
    private int maxSize;
//    private long[] stackArray;
    private char[] stackArray;
    private int top;
    public StackX(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char val){
        if(top > maxSize - 1) return;
        stackArray[++top] = val;
    }

    public char pop(){
        if(top < 0) return (char) -1;
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }
}
