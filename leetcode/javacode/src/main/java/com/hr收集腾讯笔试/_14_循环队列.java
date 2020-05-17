package com.hr收集腾讯笔试;

public class _14_循环队列 {
    public static void main(String[] args) {

    }
}

/**
 * 在循环队列中，我们总是浪费一个空间，来区分队列为满时和队列为空时的情况，
 * 也就是当 ( tail + 1 ) % capacity == front的时候，表示队列已经满了，
 * 当front == tail的时候，表示队列为空。
 *
 * https://juejin.im/post/5c95d2515188252dab3ebfc5
 * @param <T>
 */
class LoopQueue<T> {
    private T[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        data = (T[])new Object[capacity + 1];
    }

    public void enQueue(T e) {
        if((tail + 1)%data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public T deQueue() {
        if(isEmpty()) {
            throw new IllegalStateException("the queue is empty");
        }
        T t = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return t;
    }

    /**
     * 判断队列是否空
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    public void resize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        front = 0;
        tail = size;
    }

    private int getCapacity() {
        // 注意：在初始化队列的时候，我们有意识的为队列加了一个空间，那么它的实际容量自然要减1
        return data.length - 1;
    }
}
