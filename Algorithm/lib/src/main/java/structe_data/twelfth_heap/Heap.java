package structe_data.twelfth_heap;

/**
 * Created by taowei on 2017/7/25.
 * 2017-07-25 10:47
 * Algorithm
 * structe_data.twelfth_heap
 */

public class Heap {
    private Node[] heapArray;
    private int currentSize;
    private int maxSize;
    private Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[mx];
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    private boolean insert(int key){
        //已经满了
        if(currentSize == maxSize){
            return false;
        }

        Node node = new Node(key);
        heapArray[currentSize] = node;
        currentSize++;

        //将新的元素插入到堆中的最后一个节点，向上suai选
        trickleUp(currentSize-1);

        return true;
    }

    private void trickleUp(int indexBottom) {
        int parent = (indexBottom - 1)/2;
        Node bottom = heapArray[indexBottom];

        while (indexBottom > 0
                && heapArray[parent].getKey() < bottom.getKey() ){
            //如果父节点比自己还小，则交换位置
            heapArray[parent] = heapArray[indexBottom];
            indexBottom = parent;
            parent = (parent -1)/2;
        }
        //这一轮比较下来，parent 会比indexBottom 值大，只要将插入的node放到当前位置
        heapArray[indexBottom] = bottom;
    }

    public Node remove(){
        //为空，则返回
        if(currentSize == 0){
            return  null;
        }

        Node root = heapArray[0];
        //删除后，需要将最后一个节点放到根节点位置，然后向下suai选
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largeChild;//比根节点更大的子节点
        Node top = heapArray[index];//根节点

        while (index < currentSize/2){
            int leftChild = 2 * index +1;
            int rightChild = leftChild +1;

            //比较左子节点和右子节点哪个更大
            if(rightChild < currentSize &&
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largeChild = rightChild;
            else
                largeChild = leftChild;
            //如果子节点都小于根节点，则向下suai选了
            if(top.getKey() > heapArray[largeChild].getKey())
                break;
            //反之，和较大的子节点交换位置
            heapArray[index] = heapArray[largeChild];
            index = largeChild;
        }
        //最后，index停留的位置，就是最初根节点的位置
        heapArray[index] = top;
    }
}

