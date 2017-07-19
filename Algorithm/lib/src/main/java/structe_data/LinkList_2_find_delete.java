package structe_data;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 20:48
 * Algorithm
 * structe_data
 */

public class LinkList_2_find_delete {
    public static void main(String[] args){
        LinkList linkList = new LinkList();
        for(int i = 1; i < 10; i++){
            linkList.insertFirst(i,i*2);
        }
        linkList.displayList();
        // -------------- delete
        Link link = linkList.delete(9);
        linkList.displayList();
        link.displayLink();
        // -------------- find
        Link link2 = linkList.find(4);
        link2.displayLink();

    }
}
