package com.fis.queue;

public class QNode<T> {
    T key;
    QNode next;

    // constructor to create a new linked list node
    public QNode(T key)
    {
        this.key = key;
        this.next = null;
    }
}
