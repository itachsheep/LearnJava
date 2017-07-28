package structe_data.fivth_linklist;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 20:20
 * Algorithm
 * structe_data
 */

public class LinkList {
    private Link first;
    public LinkList(){
        first = null;
    }

    public Link delete(int key){
        Link pre = first,current = pre.next;
        if(first.iData == key) {
            first = first.next;
            return pre;
        }
        while(current != null){
            if(current.iData == key){
                pre.next = current.next;
                return current;
            }
            pre = current;
            current = current.next;
        }
        return current;
    }

    public Link find(int key){
        Link current = first;
        while(current != null){
            if(current.iData == key){
                return current;
            }
            current = current.next;
        }
        return current;
    }

    public void displayList(){
        System.out.print("List (firt --> last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public Link deleteFirst(){
        if(first == null) return null;
        Link node = first;
        first = first.next;
        return node;
    }

    public void insertFirst(int id, double dd){
        Link node = new Link(id,dd);
        node.next = first;
        first = node;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
class Link{
    public int iData;
    public double dData;
    public Link next;
    public Link(int i,double d){
        iData = i;
        dData = d;
    }
    public void displayLink(){
        System.out.print("{ "+iData+" , "+dData+" }");
    }
}
