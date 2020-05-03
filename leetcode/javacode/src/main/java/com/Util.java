package com;

import java.util.Iterator;
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
}
