package structe_data.eighth_binary_tree;

/**
 * Created by taowei on 2017/7/22.
 * 2017-07-22 17:30
 * Algorithm
 * structe_data.eighth_binary_tree
 */

public class Tree {
    private Node root;
    public Node find(int key){
        Node current = root;
        while (current != null){
            if(current.iData == key) return current;
            if(current.iData > key)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return current;
    }

    public void insert(int id, double dd){
        Node newNode = new Node(id,dd);
        if(root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(current.iData > id){
                    //左子树
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    //右子树
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node current){
        if(current != null){
            inOrder(current.leftChild);
            System.out.print(current.iData+", ");
            inOrder(current.rightChild);
        }
    }

    public Node minNode(){
        Node current = root,last = null;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }
    public void delete(int id){

    }
}
