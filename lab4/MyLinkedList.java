
/**
 * TODO - your comments here
 */

package lab4;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class MyLinkedList<T> extends AbstractList<T> {
	Node head, tail;
	int size;

	protected class Node {
		T data;
		Node next;
		Node prev;

		protected Node() {
			data = null;
			next = null;
			prev = null;
		}
	}  // end of the Node class

	public MyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	private Node getNth(int index) {
		Node p = this.head;
		for (int i = 0; i <= index; i++) {
			p = p.next;
		}
		return p;
	}
	
	public boolean add(T data) {
		return true;
	}
	
	public void add (int index, T data) throws IndexOutOfBoundsException{
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = head.next;
			Node add = this.head;
			current.next.prev = add;
			add.next = current.next;
			current.next = add;
			add.prev = current;
		}
	}

	@Override
	public T get(int i) {
		Node n = this.head;
		for (int j = 0; j <= i; j++) {
			n = n.next;
		}
		return n.data;
	}
	
	public T set(int i, T data) {
		Node n = this.head;
		T val = n.data;
		for (int j = 0; j <= i; j++) {
			n = n.next;
			val = n.data;
		}
		return val;
	}
	
	public T remove(int i) {
		Node n  = this.head;
		for (int j = 0; j <= i; j++) {
			n = head.next;
			n = n.prev;
		}
		return n.data;
	}

	public void clear() {
		Node n = this.head;
		n = n.next;
		n = n.prev;
	}
	
	public boolean isEmpty() {
		return true;
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	class MyLinkedListIterator implements ListIterator<T> {

	    // class variables here
		Node head;
		Node next;
		Node current = head;
		public MyLinkedListIterator(){
			current = new Node();
		}
		
	    public boolean hasNext() {
	    	return current != null;
	    }

		@Override
		public T next() throws NoSuchElementException {
			if (hasNext()) {
                T data = current.data;
                current = current.next;
                return data;
            }
            return null;
        }		
			

		@Override
		public boolean hasPrevious() {
			return current != null;
		}

		@Override
		public T previous() throws NoSuchElementException{
			if (hasPrevious()) {
				T data = current.data;
				current = current.prev;
				return data;
			}
			return null;
		}

		@Override
		public int nextIndex() {
			size = 0;
			int index = 0;
			if (current == head) {
				for (int i = 0; i <= size; i++) {
					current.next = head.next;
					index = i;
					size++;
				}
				return index;
			}
			else {
				return size;
			}
		}

		@Override
		public int previousIndex() {
			size = 0;
			int index = -1;
			if (current == head) {
				return index;
				}
			else {
				for (int i = 0; i <= size; i++) {
					current.prev = head.next;
					index = i;
					size++;
				}
			}
			return index;
		}

		@Override
		public void remove() throws IllegalStateException{
			Node n = this.head;
			n = head.next;
			n = n.prev;	
		}

		@Override
		public void set(T e) throws IllegalStateException{
			Node n = this.head;
			T val = n.data;
			n = n.next;
			val = n.data;
		}

		@Override
		public void add(T e) {
			Node current = this.head;
			current = head.next;
			Node add = this.head;
			current.next.prev = add;
			add.next = current.next;
			current.next = add;
			add.prev = current;
		}

	    // more methods, etc.
		
		ListIterator<T> myListIterator(){
			MyLinkedListIterator iter = new MyLinkedListIterator();
			return iter;
		}
		
		Iterator<T> myIterator(){
			MyLinkedListIterator iter = new MyLinkedListIterator();
			return iter;
		}
	}
	 
}
