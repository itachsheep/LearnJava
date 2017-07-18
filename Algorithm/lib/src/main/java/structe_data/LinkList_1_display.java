package structe_data;

import java.util.LinkedList;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 20:36
 * Algorithm
 * structe_data
 */

public class LinkList_1_display {
    public static void main(String[] args){
        LinkList linkList = new LinkList();
        for(int i = 1; i < 10; i++){
            linkList.insertFirst(i,i*2);
        }

        linkList.displayList();
        while (!linkList.isEmpty()){
            linkList.deleteFirst();
            Utils.log("---------------delete success----------------");
            linkList.displayList();
        }
    }
}
