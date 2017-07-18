package structe_data;

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
