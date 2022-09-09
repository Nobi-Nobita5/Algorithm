package algorithm.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;

public class LC_124_设计哈希集合 {
    /** Initialize your data structure here. */
    private LinkedList[] data;//LinkedList类型的集合
    private static final int BASE = 678;
    public LC_124_设计哈希集合() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()){
            Integer element = it.next();
            if (element == key) return;
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()){
            Integer element = it.next();
            if (element == key) data[h].remove(element);
            return;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()){
            Integer element = it.next();
            if (element == key) return true;
        }
        return false;
    }

    private int hash(int key) {
        return key%BASE;
    }
}
