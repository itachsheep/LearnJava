package structe_data.forth_stack_and_queue;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 17:04
 * Algorithm
 * structe_data
 */

public class QueueX {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
    private QueueX(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(long i){
        if(nItems == maxSize){
            throw new IllegalArgumentException("queue is full");
        }
        if(rear == maxSize){
            rear = -1;
        }
        queArray[++rear] = i;
        nItems++;
    }

    public long remove(){
        if(nItems == 0){
            throw new IllegalArgumentException("queue is empty");
        }
        if(front == maxSize) front = 0;
        long temp = queArray[front++];
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public int size(){
        return nItems;
    }


}
