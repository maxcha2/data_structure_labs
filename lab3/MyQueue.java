package lab3;

import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueADT<T> {

    class Node {
        T data;
        Node next;
        Node( T data) {
            this.data = data;
            this.next = null;
        }
        Node( ) {
            this(null);
        }
    }
    Node head, tail;
    public MyQueue( ) {
        head = new Node();
        tail = head;
    }
    @Override
    public void enqueue(T item) {
        // TODO Auto-generated method stub
    }
    @Override
    public T dequeue() throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public T front() throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void clear() {
        // TODO Auto-generated method stub
            
    }
    

}
