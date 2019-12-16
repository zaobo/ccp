package com.zab.hccpexample.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample3 {

    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v) { // foreach
        for (Integer i : v) {
            if (new Integer(3).equals(i)) {
                v.remove(i);
            }
        }
    }

    // 1会java.util.ConcurrentModificationException
    // 2success
    private static void test2(Vector<Integer> v) { // iterator
        for (Iterator<Integer> it = v.iterator(); it.hasNext(); ) {
            if (new Integer(3).equals(it.next())) {
//                1.v.remove(it.next());
//                2.it.remove();
            }
        }
        System.err.println(v.size());
    }

    private static void test3(Vector<Integer> v) { // for
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).equals(3)) {
                v.remove(i);
            }
        }
        System.err.println(v.size());
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        test1(vector);

    }

}
