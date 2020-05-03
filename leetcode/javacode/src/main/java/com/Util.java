package com;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Util<T> {

    public void printHashSet(Set<T> integers) {
        Iterator<T> iterator = integers.iterator();
        System.out.println("the set is: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " -> ");
        }
        System.out.println();
    }

    public void printArrays(T[] arr){
        System.out.println("the arr is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void printArrayList(List<T> list){
        System.out.println("the list is: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
